package com.hyunbin.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hyunbin.dao.BoardMybatisDAO;
import com.hyunbin.dto.BoardVO;

public class BoardListActionPaging implements Action{

	
	private static final int listMax=10;//한 페이지에 띄울 list 갯수
	private static final int pageMax=1;//페이지 그룹에서 페이지의 갯수
		
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command=request.getParameter("command");
		String pageNum=request.getParameter("pageNum");//클릭 페이지 받아오기
		String url="/board/boardList.jsp";
		
		System.out.println("여기여기:  "+pageNum);
		if(pageNum==null){
			pageNum="1";
		}
		
		int currentNum=Integer.parseInt(pageNum);
		int startRow = (currentNum-1)*listMax+1;
		int endRow = currentNum*listMax;
		
		int totalCnt=0;
		BoardMybatisDAO bDao = new BoardMybatisDAO();
		
		List<BoardVO> boardList=bDao.selectAllBoards();
		totalCnt=boardList.size();
		List<BoardVO> tmeList = new ArrayList<BoardVO>();
		
		
		if(totalCnt>0){
		int i=0;	
		if(totalCnt<endRow)
			endRow=totalCnt;
			
			while(true){// listMax의 크기만큼 받아옴.
				if(i>=(endRow-(currentNum-1)*10))
					break;	
			tmeList.add(boardList.get(startRow+i-1));
				i++;
			}
		}else
			tmeList = null;//////한페이지에 등록 할 수있는 리스트의 형태
		int pageGroupCount = totalCnt/(listMax*pageMax)+ ((totalCnt%listMax*pageMax)==0?0:1);//페이지 그룹의 갯수
		
		int pageGroupNum = (int)Math.ceil((double)currentNum/pageMax);//현재 페이지의  페이지 그룹 번호
		
		request.setAttribute("pageGroupNum", pageGroupNum);
		request.setAttribute("pageGroupCount", pageGroupCount);
		request.setAttribute("pageMax", pageMax);
		request.setAttribute("listMax", listMax );
		request.setAttribute("tmeList", tmeList);
		request.setAttribute("currentNum",currentNum);
		request.setAttribute("totalCnt", totalCnt);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
