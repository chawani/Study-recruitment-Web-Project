package kr.or.swithme.recrustudy.dto;

import java.util.Date;

public class Comment {
	private Long comment_id;
	private Long member_id;
	private Long post_id;
	private String comment_content;
	private Date comment_date;
	private boolean check_join;
	public Long getComment_id() {
		return comment_id;
	}
	public void setComment_id(Long comment_id) {
		this.comment_id = comment_id;
	}
	public Long getMember_id() {
		return member_id;
	}
	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}
	public Long getPost_id() {
		return post_id;
	}
	public void setPost_id(Long post_id) {
		this.post_id = post_id;
	}
	public String getComment_content() {
		return comment_content;
	}
	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	public boolean isCheck_join() {
		return check_join;
	}
	public void setCheck_join(boolean check_join) {
		this.check_join = check_join;
	}
	@Override
	public String toString() {
		return "Comment [comment_id=" + comment_id + ", member_id=" + member_id + ", post_id=" + post_id
				+ ", comment_content=" + comment_content + ", comment_date=" + comment_date + ", check_join="
				+ check_join + "]";
	}
}
