package kr.or.swithme.recrustudy.service;

import java.security.Principal;
import java.util.List;

import kr.or.swithme.recrustudy.dto.Review;

public interface ReviewService {
	public List<Review> getReviews(Long id);
	public Review addReview(Review review,Principal principal,Long id,Long week);
	public void setGrade(Long id,int amount,Double grade);
}
