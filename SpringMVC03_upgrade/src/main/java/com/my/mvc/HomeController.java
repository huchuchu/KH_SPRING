package com.my.mvc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.mvc.dto.CustomerDto;
import com.my.mvc.model.biz.CustomerBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private CustomerBiz biz;
	
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list.do")
	public String selectList(Model model) {
		
		logger.info("<<<list>>>");
		model.addAttribute("list", biz.selectList());
		return "list";
	}
	
	@RequestMapping("/insertform.do")
	public String insertform() {
		return "insertform";
	}
	@RequestMapping("/insert.do")
	public String insert(@ModelAttribute CustomerDto dto) {
		int res = biz.insert(dto);
		
		if(res>0) {
			return "redirect:list.do";
			
		}else {
			return "redirect:insertform.do";
		}
		
	}
	
	@RequestMapping("/selectone.do")
	public String selectOne(String id, Model model) {
		
		CustomerDto dto = biz.selectOne(id);
		
		model.addAttribute("dto",dto);		
		
		return"detail";
	}
	
	@RequestMapping("/updateform.do")
	public String updateform(String id, Model model) {
		
		model.addAttribute("dto", biz.selectOne(id));
		return "updateform";
	}
	
	@RequestMapping("/update.do")
	public String update(@ModelAttribute CustomerDto dto) throws UnsupportedEncodingException {
		int res = biz.update(dto);
		
		if(res>0) {
			return "redirect:selectone.do?id="+URLEncoder.encode(dto.getId(),"UTF-8");
		}else {
			return "redirect:updateform.do";
		}
		
	}
	
	@RequestMapping("/delete.do")
	public String delete(String id) {
		
		int res = biz.delete(id);
		
		if(res>0) {
			return "redirect:list.do";
		}else {
			return "redirect:selectone.do";
		}
		
	}
	
	@RequestMapping("/muldel.do")
	public String muldel(String[] chk) {
		
	int res = biz.multidelete(chk);
	
	if(res>0) {
		return "redirect:list.do";
	}else {
		return "redirect:list.do";
	}
		
	}
	
	
	
	
	
	
}
