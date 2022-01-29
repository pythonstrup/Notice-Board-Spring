package com.bigbell.noticeboard.dao;

import java.util.List;

import com.bigbell.noticeboard.entity.Board;

public interface BoardDAO {

	// Read
	public List<Board> getBoards();

	public Board getBoard(int id);

	public void saveBoard(Board board);

	public void deleteBoard(int id);

}
