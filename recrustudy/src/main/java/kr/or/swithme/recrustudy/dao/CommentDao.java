package kr.or.swithme.recrustudy.dao;

import static kr.or.swithme.recrustudy.dao.CommentDaoSqls.SELECT_COMMENT_PAGING;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.swithme.recrustudy.dto.Comment;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);

    public CommentDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("Comment")
                .usingGeneratedKeyColumns("comment_id"); //id 자동입력
    }
    
    public List<Comment> selectAll(Integer document) {
    		Map<String, Integer> params = new HashMap<>();
    		params.put("document", document);
        return jdbc.query(SELECT_COMMENT_PAGING, params, rowMapper);
    }
    
    public Long insert(Comment comment) {
    	SqlParameterSource params=new BeanPropertySqlParameterSource(comment);
    	return insertAction.executeAndReturnKey(params).longValue();
    }
}
