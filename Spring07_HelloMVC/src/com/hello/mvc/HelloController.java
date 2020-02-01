
package com.hello.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {
	
	@Autowired
	private HelloBiz biz;
	
	//TODO : 04. controller(hello.ho)
	@RequestMapping("/hello.ho")
	public String getHello(Model model) {
		
		//TODO : 05.biz.getHello();
		model.addAttribute("message", biz.getHello());
		//TODO : 09. model의 return 값 담기
		
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	
	@RequestMapping("/bye.ho")
	public ModelAndView getBye(@RequestParam("name") String str) {
								//파라미터 이름을 명시적으로 바꾸고 싶을 때 @RequestParam을 사용한다 
								//HttpServletRequest request; String str = request.getParameter("name");
		ModelAndView mav  = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye, "+str);
		
		return mav;
		
	}
	
	

}


/*
 * 	@RequestMapping 
 * 		- RequestMapping annotation은 url을 class또는 method와 mapping 시켜주는 역할을 한다
 * 		- annotation을 쓰지 않을 때 지정했던 controller 등록을 위한 url  bean설정을 생략할 수 있다
 * 	
 * 	@RequestParam
 * 		- RequestParam annotation은 key=value  형태로 넘어오는 qeuryString을 mapping된 메서드의 파라미터로 지정해준다
 * 		- 주로 get방식으로 들어오는 request에서 사용한다
 * 
 *  @ModelAttibute
 *  	- ModelAttribute annotation은 화면 form 속성에서 넘어온 model을 mapping된 method의 파라미터로 지정해준다
 *  	- 주로 post 타입으로 넘어오는 form 속성의 model 값을 받아올 때 사용한다. (get/post 모두 사용 가능)
 * 
 *  @SessionAttribute
 *  	- SessionAttribute annotation은 session에서 medel의 정보를 유지하고 싶을 때 사용한다.
 * 
 * 
 * */
