/*package com.hyunbin.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyunbin.dao.BoardMybatisDAO;
import com.hyunbin.dto.BoardVO;

public class BoardListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="/board/boardList.jsp";
		BoardMybatisDAO bDao = new BoardMybatisDAO();
	
		List<BoardVO> boardList=bDao.selectAllBoards();
		
		request.setAttribute("boardList", boardList);
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
	
	
	

	
}*/
