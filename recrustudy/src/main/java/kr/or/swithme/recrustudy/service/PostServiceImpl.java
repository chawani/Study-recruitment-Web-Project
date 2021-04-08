package kr.or.swithme.recrustudy.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.swithme.recrustudy.dao.*;
import kr.or.swithme.recrustudy.dto.*;
import kr.or.swithme.recrustudy.service.*;

@Service
public class PostServiceImpl implements PostService{
	@Autowired
	PostDao postDao;

	@Override
	@Transactional
	public List<Post> getPosts(Integer start) {
		List<Post> list = postDao.selectAll(start, PostService.LIMIT);
		return list;
	}
}
