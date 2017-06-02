package com.hyunbin.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyunbin.dao.BoardMybatisDAO;
import com.hyunbin.dto.BoardVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=null;
		String num=request.getParameter("num");
		String pass=request.getParameter("pass");
		
		BoardMybatisDAO bDao = new BoardMybatisDAO();
		BoardVO bVo= bDao.selectOneBoardByNum(num);
		
		if(bVo.getPass().equals(pass)){
			
			url="/board/checkSuccess.jsp";
			
		}else{
			url="/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
			
		}
		
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
	

}
