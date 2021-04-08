package kr.or.swithme.recrustudy.service;

import java.util.List;

import kr.or.swithme.recrustudy.dto.*;
public interface PostService {
	public static final Integer LIMIT = 5;
	public List<Post> getPosts(Integer start);
//	public Post addPost(Post post);
//	public int getCount();
}
