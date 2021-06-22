package kr.or.swithme.recrustudy.dto;

public class Review {
	private Long review_id;
	private Long studygroup_id;
	private Long member_id;
	private Long week;
	private String review_content;
	
	public Long getReview_id() {
		return review_id;
	}
	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}
	public Long getStudygroup_id() {
		return studygroup_id;
	}
	public void setStudygroup_id(Long studygroup_id) {
		this.studygroup_id = studygroup_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public Long getWeek() {
		return week;
	}
	public void setWeek(Long week) {
		this.week = week;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
}
