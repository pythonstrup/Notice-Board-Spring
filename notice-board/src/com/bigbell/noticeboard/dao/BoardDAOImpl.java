package com.bigbell.noticeboard.dao;

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

	
}
