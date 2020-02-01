package com.spr.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spr.mvc.biz.MyMvcBiz;
import com.spr.mvc.dto.MyMvcDto;

@Controller
public class SprController {
	
	@Autowired
	private MyMvcBiz biz;
	
	@RequestMapping("/boardlist.spr")
	public String selectList(Model model) {
		
		model.addAttribute("list", biz.selectList());
		return "boardlist";
		
	}
	
	@RequestMapping("/insertform.spr")
	public String insertForm() {
		
		return "boardinsert";
	}
	
	@RequestMapping("/insert.spr")
	public String insert(@ModelAttribute MyMvcDto dto) {
		
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:boardlist.spr";
			
		}else {
			return "insertform.spr";
		}
	}
	
	@RequestMapping("/boarddetail.spr")
	public String boarddetail(Model model, int seq) {
		
		MyMvcDto dto = biz.selectone(seq);
		
		model.addAttribute("dto", dto);
		return "boarddetail";
	}
	
	@RequestMapping("/updateform.spr")
	public String updateform(int seq, Model model) {
		
		MyMvcDto dto = biz.selectone(seq);
		
		model.addAttribute("dto", dto);		
		
		return"boardupdate";
	}
	
	@RequestMapping("/update.spr")
	public String update(@ModelAttribute MyMvcDto dto) {
		
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:boardlist.spr";
		}else {
			return "redirect:updateform.spr";
		}
		
		
	}
	
	@RequestMapping("/delete.spr")
	public String delete(int seq) {
		
		int res = biz.delete(seq);
		if(res>0) {
			return "redirect:boardlist.spr";
		}else {
			return "redirect:boarddetail.spr?seq="+seq;
		}
		
		
	}
	
	@RequestMapping("/muldel.spr")
	public String multidelete(int[] chk) {
		
		int res = biz.multidelete(chk);
		
		if(res>0) {
			return "redirect:boardlist.spr";
		}else {
			return "redirect:boardlist.spr";
		}
		
		
		
	}
	
	
	
	
	

}
