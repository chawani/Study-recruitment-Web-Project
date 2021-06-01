package kr.or.swithme.recrustudy.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import static kr.or.swithme.recrustudy.dao.StudyGroupDaoSqls.*;

@Repository
public class StudyGroupDao {
	private NamedParameterJdbcTemplate jdbc;

    public StudyGroupDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }
    
    public void start(Integer id) {
    	Map<String, Integer> params = Collections.singletonMap("post_id", id);
    	jdbc.update(CREATE_BY_POST_ID, params);
    	jdbc.update(CREATE_MEMBER_LIST, params);
    	jdbc.update(UPDATE_POST, params);
    	jdbc.update(CREATE_MEMBER_WRITER,params);
        return;
    }
}
