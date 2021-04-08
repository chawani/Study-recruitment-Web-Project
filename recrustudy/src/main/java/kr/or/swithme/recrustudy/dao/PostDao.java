package kr.or.swithme.recrustudy.dao;
import java.util.Collections;
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

import kr.or.swithme.recrustudy.dto.*;

import static kr.or.swithme.recrustudy.dao.PostDaoSqls.*;

@Repository
public class PostDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Post> rowMapper = BeanPropertyRowMapper.newInstance(Post.class);

    public PostDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("Post")
                .usingGeneratedKeyColumns("post_id"); //id 자동입력
    }
    
    public List<Post> selectAll(Integer start, Integer limit) {
    		Map<String, Integer> params = new HashMap<>();
    		params.put("start", start);
    		params.put("limit", limit);
        return jdbc.query(SELECT_PAGING, params, rowMapper);
    }

}