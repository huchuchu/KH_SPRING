package com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.biz.MyMvcBiz;
import com.mvc.biz.imple.MyMvcBizImple;
import com.mvc.dto.MyMvcDto;

//리퀘스트가 들어오면 url패턴들이 잡아서?? 리퀘스트를 실행해줌????
@WebServlet(urlPatterns= {"/selectlist", "/detail","/insertform","/insert","/updateform", "/update", "/delete"})
public class reqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MyMvcBiz biz; 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		getRequest(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		getRequest(request, response);
		
	}
	
	
	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		biz = new MyMvcBizImple();
		
		String command = request.getRequestURI();
		System.out.println("<"+command+">");
		
		if(command.endsWith("/selectlist")) {
			doSelectList(request, response);
		}else if(command.endsWith("/detail")) {
			doSelectOne(request,response);
		}else if(command.endsWith("/insertform")) {
			doinsertform(request,response);
		}else if(command.endsWith("/insert")) {
			doinsert(request, response);
		}else if(command.endsWith("/updateform")) {
			doupdateform(request, response);
		}else if(command.endsWith("/update")) {
			doupdate(request, response);
		}else if(command.endsWith("/delete")) {
			dodelete(request, response);
		}
		
	}


	private void dodelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		int res = biz.delete(seq);
		if(res>0) {
			System.out.println("삭제성공");
			dispatch(request, response, "selectlist");
		}else {
			System.out.println("삭제실패");
			dispatch(request, response, "selectlist");
		}
		
	}


	private void doupdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MyMvcDto dto = new MyMvcDto();
		dto.setSeq(seq);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = biz.update(dto);
		if(res>0) {
			System.out.println("수정성공");
			dispatch(request, response, "selectlist");
		}else {
			System.out.println("수정실패");
			dispatch(request, response, "updateform?seq="+seq);
		}
		
	}


	private void doupdateform(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int seq = Integer.parseInt(request.getParameter("seq"));
		MyMvcDto dto = biz.selectone(seq);
	
		request.setAttribute("dto", dto);
		dispatch(request, response, "boardupdate.jsp");
		
	}


	private void doinsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MyMvcDto dto = new MyMvcDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);				
		
		int res = biz.insert(dto);
		if(res>0) {
			System.out.println("글 작성완료");
			dispatch(request, response, "selectlist");
			
		}else {
			System.out.println("글 작성 실패");
			dispatch(request, response, "insertform");
		}
		
		
	}


	private void doinsertform(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
		response.sendRedirect("boardinsert.jsp");
		
	}


	private void doSelectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MyMvcDto dto = biz.selectone(seq);
		request.setAttribute("dto", dto);
		dispatch(request, response, "boarddetail.jsp");
	}


	private void doSelectList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MyMvcDto>list = biz.selectList();
		request.setAttribute("list", list);
		dispatch(request, response, "boardlist.jsp");
		
		
	}
	
	public void dispatch(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(url);
		dispatch.forward(request, response);
	}

}
