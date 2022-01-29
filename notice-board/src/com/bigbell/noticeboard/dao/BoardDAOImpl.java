package com.bigbell.noticeboard.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bigbell.noticeboard.entity.Board;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	// inject the sessionFactory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Board> getBoards() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Board> query = 
				currentSession.createQuery("from Board order by id",
											Board.class);
		
		List<Board> boards = query.getResultList();
		
		return boards;
	}

	@Override
	public Board getBoard(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Board board = currentSession.get(Board.class, id);
		
		return board;
	}

	@Override
	public void saveBoard(Board board) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		// java.sql.SQLIntegrityConstraintViolationException 오류가 발생하기 때문에 설정해줘야함.
		// write-form에서 form:hidden 태그를 통해 해결가능!!!
//		board.setVisitcount(0);
		board.setPostdate(new Timestamp(System.currentTimeMillis()));
		
		currentSession.saveOrUpdate(board);
	}

	@Override
	public void deleteBoard(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query query = 
				currentSession.createQuery("delete from Board where id=:customerId");
		query.setParameter("customerId", id);
		
		query.executeUpdate();
	}

	
}
