package kr.or.swithme.recrustudy.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.swithme.recrustudy.dao.MemberDao;
import kr.or.swithme.recrustudy.dto.*;
import kr.or.swithme.recrustudy.service.CommentService;
import kr.or.swithme.recrustudy.service.PostService;
import kr.or.swithme.recrustudy.service.StudyGroupService;

@Controller
public class PostController {
	@Autowired
	PostService postService;
	@Autowired
	CommentService commentService;
	@Autowired
	StudyGroupService studyGroupService;
	@Autowired
	MemberDao memberDao;
	
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

	@PostMapping(path="/postInsert")
	public String write(@ModelAttribute Post post,Principal principal) {
		postService.addPost(post,principal);
		return "redirect:/list";
	}
	
	@RequestMapping(value ="/detail", method = RequestMethod.GET)
    public String detail(@RequestParam("document") Integer document, Model model, Principal principal) throws Exception{
		Post post = postService.getPost(document);
		List<Comment> comment = commentService.getComments(document);
		Member member=memberDao.getMemberByEmail(principal.getName());
		boolean check=false;
		if (member.getId()==post.getMember_id()){
			check=true;
		}
		model.addAttribute("writer",check);
        model.addAttribute("post",post);
        model.addAttribute("comment",comment);
        return "/detailpage";
    }
	
	@RequestMapping(value="/writeComment",method = RequestMethod.POST)
	public String commentWrite(@RequestParam("document") Long document, @ModelAttribute Comment comment, Principal principal) {
		commentService.addComment(comment,principal,document);
		return "redirect:/detail?document="+document;
	}
	
	@RequestMapping(value="/accept",method = RequestMethod.GET)
	public String commentAccept(@RequestParam("comment") Integer comment,@RequestParam("document") Long document, Model model) {
		commentService.acceptComment(comment);
	    return "redirect:/detail?document="+document;
	}
	@RequestMapping(value="/delete_accept",method = RequestMethod.GET)
	public String commentAcceptDelete(@RequestParam("comment") Integer comment,@RequestParam("document") Long document, Model model) {
		commentService.delete_acceptComment(comment);
	    return "redirect:/detail?document="+document;
	}
	
	@RequestMapping(value="/group",method = RequestMethod.GET)
	public String groupSetting(@RequestParam("document") Integer document, Model model) {
		List<Comment> list=commentService.search_acceptComment(document);
		model.addAttribute("list",list);
	    return "/groupsetting";
	}
	
	@RequestMapping(value="/start",method = RequestMethod.GET)
	public String start(@RequestParam("document") Integer document) {
		studyGroupService.startStudy(document);
	    return "redirect:/mypage";
	}
}
