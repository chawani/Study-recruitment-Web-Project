package kr.or.swithme.recrustudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.swithme.recrustudy.dto.Comment;
import kr.or.swithme.recrustudy.service.CommentService;

@Controller
public class StudyGroupController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value="/studygroup",method = RequestMethod.GET)
	public String review(@RequestParam("document") Integer document, Model model) {
		List<Comment> list=commentService.search_acceptComment(document);
		model.addAttribute("list",list);
	    return "/review";
	}
}
