package com.hyunbin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.hyunbin.dto.BoardVO;
import com.hyunbin.mybatis.MyBatis;

public class BoardMybatisDAO implements BoardDAOmap{

    private SqlSessionFactory sessionFactory = null;

	
	
	public BoardMybatisDAO(){
        sessionFactory = MyBatis.getSqlSessionFactory();
	}
	
	
	@Override
	public List<BoardVO> selectAllBoards() {
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectList("selectAllBoards");//selectList의 첫번째 인자는 네임스페이스명.함수id명 두번째 인자는 파라미터 값 넘기기. 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;		
	}

	@Override
	public void insertBoard(BoardVO bVo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		try {
			
			session.insert("insertBoard",bVo);
			
			session.commit(true);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (session != null) session.close();
		}	
	}

	@Override
	public void updateReadCount(String num) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		try {
			
			session.update("updateReadCount",num);
			session.commit(true);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}

	@Override
	public BoardVO selectOneBoardByNum(String num) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectOne("selectOneBoardByNum",num);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;	
	}

	@Override
	public void updateBoard(BoardVO bVo) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.update("updateBoard",bVo);
			session.commit(true);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}

	@Override
	public BoardVO checkPassWord(String pass, String num) {
		// TODO Auto-generated method stub
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("pass", pass);
		map.put("num", num);
		SqlSession session = this.sessionFactory.openSession();
		try {
			return session.selectOne("checkPassWord",map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return null;	
	}

	@Override
	public void deleteBoard(String num) {
		// TODO Auto-generated method stub
		SqlSession session = this.sessionFactory.openSession();
		try {
			session.delete("deleteBoard",num);
			session.commit(true);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
	}

	
	
}
