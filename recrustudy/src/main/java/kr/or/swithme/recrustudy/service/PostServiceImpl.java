package kr.or.swithme.recrustudy.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.swithme.recrustudy.dao.*;
import kr.or.swithme.recrustudy.dto.*;
import kr.or.swithme.recrustudy.service.*;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	PostDao postDao;
	@Autowired
	MemberService memberservice;

	@Override
	@Transactional
	public List<Post> getPosts(Integer start) {
		List<Post> list = postDao.selectAll(start, PostService.LIMIT);
		return list;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Post addPost(Post post, Principal principal) {
		String loginId = principal.getName();
        Member member = memberservice.getMemberByEmail(loginId);
        post.setMember_id(member.getId());
		post.setPost_date(new Date());
		Long id=postDao.insert(post);
		post.setPost_id(id);
		return post;
	}
	
	@Override
	public Post getPost(Integer document) {
		Post post=postDao.select(document);
		return post;
	}
}
