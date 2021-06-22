package kr.or.swithme.recrustudy.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.swithme.recrustudy.dto.Member;
import kr.or.swithme.recrustudy.dto.Post;

import javax.sql.DataSource;

import static kr.or.swithme.recrustudy.dao.MemberDaoSqls.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberDao {
	private JdbcTemplate jdbctemplate;
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);

	public MemberDao(DataSource dataSource){
		this.jdbctemplate=new JdbcTemplate(dataSource);
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public Member getMemberByEmail(String email){
		Map<String, Object> map = new HashMap<>();
		map.put("email", email);

		return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL_BY_EMAIL, map, rowMapper);
	}
	
	public void addMember(Member member) {
		Map<String, Object> params = new HashMap<>();
		params.put("name", member.getName());
		params.put("password", member.getPassword());
		params.put("email", member.getEmail());
		params.put("createDate", member.getCreateDate());
		params.put("modifyDate", member.getModifyDate());
		
		// Insert Query를 위해서 update method를 사용했다.
		jdbc.update(MemberDaoSqls.INSERT_MEMBER, params);
	}
	
	public List<Member> select(Long id) {
		Map<String, Long> params = new HashMap<>();
		params.put("studygroup_id", id);
		return jdbc.query(SELECT_ALL_BY_GROUP_ID, params, rowMapper);
	}
	
	public int setMemberGrade(Long id,int amount,Double grade) {
		return jdbctemplate.update("update Member set grade=? and amount=? where id=?",grade,amount,id);
	}
}