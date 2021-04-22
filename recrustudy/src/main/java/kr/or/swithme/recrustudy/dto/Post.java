package kr.or.swithme.recrustudy.dto;

import java.util.Date;

public class Post {
	private Long post_id;
	private Long member_id;
	private String category;
	private String region;
	private String title;
	private String content;
	private Date post_date;
	private boolean check_recruiting;
	private int present_number;
	private int total_number;
	private String study_period;
	private Long studygroup_id;
	public Long getPost_id() {
		return post_id;
	}
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPost_date() {
		return post_date;
	}
	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}
	public boolean isCheck_recruiting() {
		return check_recruiting;
	}
	public void setCheck_recruiting(boolean check_recruiting) {
		this.check_recruiting = check_recruiting;
	}
	public int getPresent_number() {
		return present_number;
	}
	public void setPresent_number(int present_number) {
		this.present_number = present_number;
	}
	public int getTotal_number() {
		return total_number;
	}
	public void setTotal_number(int total_number) {
		this.total_number = total_number;
	}
	public String getStudy_period() {
		return study_period;
	}
	public void setStudy_period(String study_period) {
		this.study_period = study_period;
	}
	public Long getStudygroup_id() {
		return studygroup_id;
	}
	public void setStudygroup_id(Long studygroup_id) {
		this.studygroup_id = studygroup_id;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", member_id=" + member_id + ", category=" + category + ", region=" + region
				+ ", title=" + title + ", content=" + content + ", post_date=" + post_date + ", check_recruiting="
				+ check_recruiting + ", present_number=" + present_number + ", total_number=" + total_number
				+ ", study_period=" + study_period + ", studygroup_id=" + studygroup_id + "]";
	}
	
}
