package com.bigbell.noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigbell.noticeboard.entity.Board;
import com.bigbell.noticeboard.service.BoardService;

@Controller
@RequestMapping("/board")
public class NoticeBoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String listBoard(Model model) {
		
		List<Board> boards = boardService.getBoards();
		
		model.addAttribute("boards", boards);
		
		return "list-board";
	}
	
	@RequestMapping("/content")
	public String contentBoard(@RequestParam("contentId") int id,
						Model model) {
		
		Board board = boardService.getBoard(id);
		
		model.addAttribute("board", board);
		
		return "content-board";
	}
}
