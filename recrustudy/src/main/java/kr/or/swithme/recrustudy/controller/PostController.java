package kr.or.swithme.recrustudy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.swithme.recrustudy.dto.*;
import kr.or.swithme.recrustudy.service.PostService;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	
	@GetMapping(path="/list")
	public String list(ModelMap model) {
		
		List<Post> list = postService.getPosts(0);
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@RequestMapping(value="/write")
    public String boardWrite() throws Exception {
        return "/write";
    }

//	@PostMapping(path="/postInsert")
//	public String write(@ModelAttribute Post post,
//						HttpServletRequest request) {
//		String clientIp = request.getRemoteAddr();
//		postService.addPost(post, clientIp);
//		return "redirect:list";
//	}
}
