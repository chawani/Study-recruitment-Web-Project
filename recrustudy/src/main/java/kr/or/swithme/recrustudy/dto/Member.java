package kr.or.swithme.recrustudy.dto;

public class Member {
	private String member_id;
	private String password;
	private String nickname;
	private float grade;
	private String email;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", password=" + password + ", nickname=" + nickname + ", grade="
				+ grade + ", email=" + email + "]";
	}
	
}
