package com.my.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.hello.model.HomeBiz;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeBiz biz;

	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
							//model객체를 만들어줌 
				
		model.addAttribute("message", biz.getHello());
		//model객체에 담아서 디스패처서블릿에 보내주면 ResourceViewResolver를 찾아서 페이지 경로를 읽고 보내줌 
		
		
		return "hello";
		//view페이지 : servlet-context에서 경로를 설정해두어서 페이지의 이름만 넣어도 페이지이동이 가능하다 !!
		
	}
	
//	@RequestMapping("/bye.do")
//	public ModelAndView getBye(String name) {
//		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("bye");
//		mav.addObject("message", "Bye, "+name);
//		
//		return mav;
//		
//	}
		
	@RequestMapping("/bye.do")
	public String bye(@RequestParam("name")String chi, Model model) {
		
		
		model.addAttribute("message", chi+" , bye"); 
		
		return "bye";
		
	}
	
	
}
