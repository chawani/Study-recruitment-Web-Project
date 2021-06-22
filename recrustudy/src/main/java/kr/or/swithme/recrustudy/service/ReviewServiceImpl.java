package kr.or.swithme.recrustudy.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.swithme.recrustudy.dao.MemberDao;
import kr.or.swithme.recrustudy.dao.ReviewDao;
import kr.or.swithme.recrustudy.dto.Comment;
import kr.or.swithme.recrustudy.dto.Member;
import kr.or.swithme.recrustudy.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	MemberService memberservice;
	@Autowired
	ReviewDao reviewDao;
	@Autowired
	MemberDao memberDao;
	
	@Override
	@Transactional(readOnly=false)
	public Review addReview(Review review, Principal principal,Long id,Long week) {
		String loginId = principal.getName();
        Member member = memberservice.getMemberByEmail(loginId);
        review.setMember_id(member.getId());
		review.setStudygroup_id(id);
		review.setWeek(week);
		reviewDao.insert(review);
		return review;
	}
	
	@Override
	@Transactional
	public List<Review> getReviews(Long id) {
		List<Review> list = reviewDao.selectAll(id);
		return list;
	}
	
	@Override
	@Transactional
	public void setGrade(Long id,int amount,Double grade) {
		memberDao.setMemberGrade(id,amount, grade);
	}
}
