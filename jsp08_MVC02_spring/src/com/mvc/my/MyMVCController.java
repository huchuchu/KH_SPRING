package com.mvc.my;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.my.model.biz.MyMvcBiz;
import com.mvc.my.model.dto.MyMvcDto;

@Controller
public class MyMVCController {
	
	@Autowired
	private MyMvcBiz biz;
	
	//method=RequestMethod.GET: get방식으로 들어왔을 때만 들어온다 post로 들어오면 mapping된 URL이 없습니다 오류
	@RequestMapping(value="/boardlist.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		model.addAttribute("list", biz.selectList());
		
		return "boardlist";
	}
	
	@RequestMapping("/boardinsert.do")
	public void insert() {		
	}
	
	@RequestMapping("/insert.do")
	public String insertRes(@ModelAttribute MyMvcDto dto) {
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:boardlist.do";
		}else {
			return "boardinsert.do";
		}
	}
	
	@RequestMapping("/boarddetail.do")
	public String boarddetail(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectone(seq));
				
		return "boarddetail";
	}
	
	@RequestMapping("/delete.do")
	public String delete(int seq) {
		
		int res = biz.delete(seq);
		if(res>0) {
			return "redirect:boardlist.do";
		}else {
			return "redirect:boarddetail.do?seq="+seq;
		}
	}
	
	@RequestMapping("/updateform.do")
	public String updateform(Model model, int seq) {
		
		model.addAttribute("dto", biz.selectone(seq));
				
		return "boardupdate";
	}
	
	@RequestMapping("/updateres.do")
	public String updateres(@ModelAttribute MyMvcDto dto) {
		
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:boardlist.do";
		}else {
			return "redirect:updateform.do";
		}
		

	}
	
	
	

	
	
}
