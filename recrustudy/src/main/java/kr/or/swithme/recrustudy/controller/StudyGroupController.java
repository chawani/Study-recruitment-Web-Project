package kr.or.swithme.recrustudy.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.swithme.recrustudy.dao.MemberDao;
import kr.or.swithme.recrustudy.dto.Comment;
import kr.or.swithme.recrustudy.dto.Member;
import kr.or.swithme.recrustudy.dto.Post;
import kr.or.swithme.recrustudy.dto.Review;
import kr.or.swithme.recrustudy.service.CommentService;
import kr.or.swithme.recrustudy.service.MemberService;
import kr.or.swithme.recrustudy.service.PostService;
import kr.or.swithme.recrustudy.service.ReviewService;

@Controller
public class StudyGroupController {
	@Autowired
	PostService postService;
	@Autowired
	MemberService memberService;
	@Autowired
	ReviewService reviewService;
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value="/studygroup",method = RequestMethod.GET)
	public String review(@RequestParam("document") Integer document, Model model, Principal principal) {
		Post post = postService.getPost(document);
		int period=Integer.parseInt(post.getStudy_period());
		model.addAttribute("post_id",post.getPost_id());
		model.addAttribute("period", period);
		List<Review> rlist=reviewService.getReviews(post.getStudygroup_id());
		model.addAttribute("rlist",rlist);
		List<Member> mlist=memberService.getMembers(post.getStudygroup_id());
		model.addAttribute("mlist",mlist);
		Member member=memberDao.getMemberByEmail(principal.getName());
		model.addAttribute("me",member.getId());
	    return "/review";
	}
	
	@RequestMapping(value="/writeReview",method = RequestMethod.POST)
	public String reviewWrite(@RequestParam("document") Integer document, @RequestParam("week") Long week, @ModelAttribute Review review, Principal principal) {
		Post post = postService.getPost(document);
		Long id=post.getStudygroup_id();
		reviewService.addReview(review,principal,id,week);
		return "redirect:/studygroup?document="+document;
	}
	
	@RequestMapping(value="/reviewStar",method = RequestMethod.POST)
	public String starReview(@RequestParam("document") Integer document, HttpServletRequest request, Principal principal) {
		Post post = postService.getPost(document);
		List<Member> mlist=memberService.getMembers(post.getStudygroup_id());
		for(int i=0;i<mlist.size();i++) {
			String id=Long.toString(mlist.get(i).getId());
			Double grade=mlist.get(i).getGrade()+Double.parseDouble(request.getParameter(id));
			reviewService.setGrade(mlist.get(i).getId(),mlist.get(i).getAmount()+1,grade);
		}
		return "redirect:/studygroup?document="+document;
	}
}
