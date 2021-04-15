package kr.or.swithme.recrustudy.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.swithme.recrustudy.dto.Member;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);

	public MemberDao(DataSource dataSource){
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
}