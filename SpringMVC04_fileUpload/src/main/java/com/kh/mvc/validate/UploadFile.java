package com.kh.mvc.validate;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	
	

	private String filename;
	private String desc;
	private MultipartFile file;
	//MultipartFile : 파일의 내용을 메모리나 디스크에 일시적으로 저장??
	
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}
