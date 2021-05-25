package kr.or.swithme.recrustudy.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.swithme.recrustudy.dao.CommentDao;
import kr.or.swithme.recrustudy.dao.PostDao;
import kr.or.swithme.recrustudy.dto.Comment;
import kr.or.swithme.recrustudy.dto.Member;
import kr.or.swithme.recrustudy.dto.Post;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	CommentDao commentDao;
	@Autowired
	CommentService commentservice;
	@Autowired
	MemberService memberservice;

	@Override
	@Transactional
	public List<Comment> getComments(Integer document) {
		List<Comment> list = commentDao.selectAll(document);
		return list;
	}
	
	@Override
	@Transactional(readOnly=false)
	public Comment addComment(Comment comment, Principal principal, Long document) {
		String loginId = principal.getName();
        Member member = memberservice.getMemberByEmail(loginId);
        comment.setMember_id(member.getId());
		comment.setComment_date(new Date());
		comment.setPost_id(document);
		Long id=commentDao.insert(comment);
		comment.setComment_id(id);
		return comment;
	}
	
	@Override
	public int acceptComment(int comment) {
		return commentDao.accept(comment);
	}
	@Override
	public Integer acceptCheck(int comment) {
		return commentDao.accept_check(comment);
	}
	@Override
	public int delete_acceptComment(int comment) {
		return commentDao.delete_accept_check(comment);
	}
	
	@Override
	@Transactional
	public List<Comment> search_acceptComment(Integer document){
		List<Comment> list = commentDao.search_accept(document);
		return list;
	}
}
