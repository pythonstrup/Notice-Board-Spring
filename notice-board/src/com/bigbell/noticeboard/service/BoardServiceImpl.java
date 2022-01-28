package com.bigbell.noticeboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigbell.noticeboard.dao.BoardDAO;
import com.bigbell.noticeboard.entity.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDao;

	@Override
	@Transactional
	public List<Board> getBoards() {
		
		return boardDao.getBoards();
	}

	@Override
	@Transactional
	public Board getBoard(int id) {
		
		return boardDao.getBoard(id);
	}
	
	
}
