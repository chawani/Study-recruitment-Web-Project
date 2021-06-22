package kr.or.swithme.recrustudy.dao;

import static kr.or.swithme.recrustudy.dao.ReviewDaoSqls.SELECT_ALL_REVIEW;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.or.swithme.recrustudy.dto.Comment;
import kr.or.swithme.recrustudy.dto.Review;

@Repository
public class ReviewDao {
	private JdbcTemplate jdbctemplate;
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Review> rowMapper = BeanPropertyRowMapper.newInstance(Review.class);
    
    public ReviewDao(DataSource dataSource) {
    	this.jdbctemplate=new JdbcTemplate(dataSource);
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("Review")
        		.usingGeneratedKeyColumns("review_id"); //id 자동입력
    }   
    
    @Transactional
    public Long insert(Review review) {
    	SqlParameterSource params=new BeanPropertySqlParameterSource(review);
    	return insertAction.executeAndReturnKey(params).longValue();
    }
    
    @Transactional
    public List<Review> selectAll(Long id) {
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(SELECT_ALL_REVIEW, params, rowMapper);
    }
    
}
