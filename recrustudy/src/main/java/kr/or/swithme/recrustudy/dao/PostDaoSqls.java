package kr.or.swithme.recrustudy.dao;

public class PostDaoSqls {
	public static final String SELECT_PAGING = "SELECT * FROM Post ORDER BY post_id DESC limit :start, :limit";
	public static final String SELECT_BY_ID = "SELECT * FROM Post WHERE post_id = :post_id";
	public static final String SELECT_BY_MEMBER="SELECT * FROM Post WHERE member_id = :member_id";
	public static final String SELECT_BY_COMMENT="SELECT p.* FROM Post AS p JOIN Comment AS c ON p.post_id = c.post_id WHERE c.member_id = :member_id";
//	public static final String DELETE_BY_ID = "DELETE FROM Post WHERE post_id = :post_id";
//	public static final String SELECT_COUNT = "SELECT count(*) FROM Post";
}
