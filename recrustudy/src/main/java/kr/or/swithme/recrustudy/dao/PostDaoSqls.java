package kr.or.swithme.recrustudy.dao;

public class PostDaoSqls {
	public static final String SELECT_PAGING = "SELECT post_id, member_id, title FROM Post ORDER BY post_id DESC limit :start, :limit";
//	public static final String DELETE_BY_ID = "DELETE FROM Post WHERE post_id = :post_id";
//	public static final String SELECT_COUNT = "SELECT count(*) FROM Post";
}
