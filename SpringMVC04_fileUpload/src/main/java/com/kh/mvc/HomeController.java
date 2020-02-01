package com.kh.mvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.kh.mvc.validate.FileValidator;
import com.kh.mvc.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;

	@RequestMapping(value="/form")
	public String getUploadForm() {
		
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload")
	public String fileUpload(HttpServletRequest request, Model model, 
			UploadFile uploadFile, BindingResult result) {
									
		
		//유효성검사
		//BindingResult: 객체를 Binding하다가 발생하는 error의 정보를 받기 위해 사용
		fileValidator.validate(uploadFile, result);
		if(result.hasErrors()) {
			return "uploadForm";
		}
		
		MultipartFile file = uploadFile.getFile();
		String filename = file.getOriginalFilename();
		
		//모델에 넣기위해
		UploadFile fileobj = new UploadFile();
		fileobj.setFilename(filename);
		fileobj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		
		try {
			inputStream = file.getInputStream();
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/storage");
			
			System.out.println("업로드 될 실제 경로 : " + path);
			
			
			File storage = new File(path);
			//storage 폴더 없으면 만들기
			if(!storage.exists()) {
				storage.mkdirs();
			}
			
			
			File newfile = new File(path + "/" + filename);
			
			
			if(!newfile.exists()) {
				newfile.createNewFile();
			}
			
			outputStream = new FileOutputStream(newfile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()];
			
			while((read=inputStream.read(b)) != -1) {
				outputStream.write(b, 0, read);
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileobj", fileobj);
		
		return "uploadFile";
	}
	
	@RequestMapping(value="/download")
	@ResponseBody
	public byte[] fileDown(HttpServletRequest request, 
			HttpServletResponse response, String filename) throws IOException {
		
		String path = WebUtils.getRealPath(
				request.getSession().getServletContext(), "/storage");
		File file = new File(path + "/" + filename);
		//				
						//경로를 복사해서 바이트타입 배열에 넣는다???
		byte[] bytes = FileCopyUtils.copyToByteArray(file);
		String fn = new String(file.getName().getBytes(),"8859_1");//한글인코딩
		
		response.setHeader("Content-Disposition", 
				"attachment;filename=\""+fn+"\"");
		response.setContentLength(bytes.length);
		response.setContentType("image/jpeg");
		//mime type: tomcat web.xml 
		
		
		return bytes;
	}
}







