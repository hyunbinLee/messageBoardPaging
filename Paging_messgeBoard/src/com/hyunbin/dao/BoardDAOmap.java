package com.hyunbin.dao;

import java.util.List;

import com.hyunbin.dto.BoardVO;

public interface BoardDAOmap {

	
	public List<BoardVO> selectAllBoards();
	
	public void insertBoard(BoardVO bVo);
	
	public void updateReadCount(String num);
	
	public BoardVO selectOneBoardByNum(String num);
	
	public void updateBoard(BoardVO bVo);
	
	public BoardVO checkPassWord(String pass, String num);
	
	public void deleteBoard(String num);
}
