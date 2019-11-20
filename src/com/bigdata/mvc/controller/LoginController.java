package com.bigdata.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigdata.mvc.dao.MemberDAO;

public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String msg = "";
		String path = "";

		MemberDAO mdao = new MemberDAO();
		HttpSession session = request.getSession(); 
		
		if (id.equals("") || pwd.equals("")) {
			msg = "ID 또는 Password를 입력해 주세요";
			path = "/login";
		} else {
			String dbId = mdao.selectLogin(id, pwd);
			if (!dbId.equals("")) { 
				session.setAttribute("id", dbId);
				path = "menu";
			} else {
				msg = "ID 또는 Password가 틀렸습니다.";
				path = "/login";
			}
		}
		
		request.setAttribute("msg", msg);
		
		if(session.getAttribute("id")!=null){
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
