package com.bigdata.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata.mvc.dao.MemberDAO;
import com.bigdata.mvc.vo.MemberVO;

public class MemberSelectController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO jdbc = new MemberDAO();
		List<MemberVO> mlist = jdbc.selectAll(); //select * from member 값을 가져옴
		
		request.setAttribute("mlist", mlist);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/member_list.jsp");
		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
