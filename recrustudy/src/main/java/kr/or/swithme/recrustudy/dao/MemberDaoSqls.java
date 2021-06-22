package kr.or.swithme.recrustudy.dao;

public class MemberDaoSqls {
	public static final String SELECT_ALL_BY_EMAIL = "SELECT * FROM member WHERE email = :email";
	public static final String INSERT_MEMBER ="INSERT INTO member(name, password, email, create_date, modify_date) "+ "VALUES (:name, :password, :email, :createDate, :modifyDate);";
	public static final String SELECT_ALL_BY_GROUP_ID="select m.* from Member as m join Member_Studygroup as ms where m.id=ms.member_id and ms.studygroup_id=:studygroup_id";
}
