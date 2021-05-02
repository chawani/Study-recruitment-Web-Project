package kr.or.swithme.recrustudy.dao;

public class CommentDaoSqls {
	public static final String SELECT_COMMENT_PAGING = "SELECT * FROM Comment WHERE post_id=:document ORDER BY comment_id DESC";
}
