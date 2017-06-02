package com.hyunbin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyunbin.dao.BoardMybatisDAO;
import com.hyunbin.dto.BoardVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/board/boardView.jsp";
		
		String num=request.getParameter("num");
		
		BoardMybatisDAO bDao = new BoardMybatisDAO();
		
		bDao.updateReadCount(num);
		
		BoardVO bVo= bDao.selectOneBoardByNum(num);
		request.setAttribute("board", bVo);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
	
	

}
