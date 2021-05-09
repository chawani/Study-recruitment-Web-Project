package kr.or.swithme.recrustudy.service;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.Authentication;

import kr.or.swithme.recrustudy.dto.*;
public interface PostService {
	public static final Integer LIMIT = 5;
	public List<Post> getPosts(Integer start);
	public Post getPost(Integer document);
	public Post addPost(Post post,Principal principal);
	public List<Post> getMemberPost(Principal principal);
	public List<Post> getCommentPost(Principal principal);
//	public int getCount();
}
