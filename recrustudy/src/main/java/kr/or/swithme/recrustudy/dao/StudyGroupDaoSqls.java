package kr.or.swithme.recrustudy.dao;

public class StudyGroupDaoSqls {
	public static final String CREATE_BY_POST_ID="insert into Studygroup(post_id,study_period,start_day) select post_id,study_period,curdate() from Post where post_id=:post_id";
	public static final String CREATE_MEMBER_LIST="insert into Member_Studygroup(member_id,studygroup_id) select Comment.member_id, Studygroup.studygroup_id from Comment,Post,Studygroup where Post.post_id=Comment.post_id and Post.post_id=Studygroup.post_id and Comment.check_join=1 and Comment.post_id=:post_id";
	public static final String CREATE_MEMBER_WRITER="insert into Member_Studygroup(member_id,studygroup_id) select member_id,studygroup_id from Post where post_id=:post_id";
	public static final String UPDATE_POST="update Post set studygroup_id=(select studygroup_id from Studygroup where post_id=:post_id ) WHERE post_id=:post_id";
}
