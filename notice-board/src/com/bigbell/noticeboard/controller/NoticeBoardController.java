package com.bigbell.noticeboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bigbell.noticeboard.entity.Board;
import com.bigbell.noticeboard.service.BoardService;

@Controller
@RequestMapping("/board")
public class NoticeBoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/list")
	public String listBoard(Model model) {
		
		List<Board> boards = boardService.getBoards();
		
		model.addAttribute("boards", boards);
		
		return "list-board";
	}
	
	@GetMapping("/content")
	public String contentBoard(@RequestParam("contentId") int id,
						Model model) {
		
		Board board = boardService.getBoard(id);
		
		model.addAttribute("board", board);
		
		return "content-board";
	}
	
	@GetMapping("/write")
	public String writeBoard(Model model) {
		
		Board board = new Board();
		
		model.addAttribute("board", board);
		
		return "write-form";
	}
	
	@PostMapping("/saveBoard")
	public String saveBoard(@ModelAttribute("board") Board board) {
		
		boardService.saveBoard(board);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/update")
	public String updateBoard(@RequestParam("contentId") int id
								, Model model) {
		
		Board board = boardService.getBoard(id);
		
		model.addAttribute(board);
		
		return "write-form";
	}
	
	@GetMapping("/delete")
	public String deleteBoard(@RequestParam("contentId") int id,
								Model model) {
		
		boardService.deleteBoard(id);
		
		return "redirect:/board/list";
	}
	
}
