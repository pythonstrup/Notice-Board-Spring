package com.bigbell.noticeboard.service;

import java.util.List;

import com.bigbell.noticeboard.entity.Board;

public interface BoardService {
	
	public List<Board> getBoards();

	public Board getBoard(int id);

	public void saveBoard(Board board);

	public void deleteBoard(int id);
}
