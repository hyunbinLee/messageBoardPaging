package com.hyunbin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyunbin.dao.BoardMybatisDAO;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num=request.getParameter("num");
		
		BoardMybatisDAO bDao = new BoardMybatisDAO();
		bDao.deleteBoard(num);
		
		new BoardListActionPaging().execute(request, response);
		
	}
	
	

}
