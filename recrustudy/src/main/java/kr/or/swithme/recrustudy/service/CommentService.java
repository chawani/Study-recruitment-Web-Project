package kr.or.swithme.recrustudy.service;

import java.security.Principal;
import java.util.List;

import kr.or.swithme.recrustudy.dto.Comment;

public interface CommentService {
	public static final Integer LIMIT = 10;
	public List<Comment> getComments(Integer document);
	public Comment addComment(Comment comment,Principal principal,Long document);
	public int acceptComment(int comment);
	public Integer acceptCheck(int comment);
	public int delete_acceptComment(int comment);
	public List<Comment> search_acceptComment(Integer document);
}
