package kr.or.swithme.recrustudy.service;

import java.util.List;

import kr.or.swithme.recrustudy.dto.Member;
import kr.or.swithme.recrustudy.service.security.UserDbService;

public interface MemberService extends UserDbService {
	void addMember(Member member, boolean admin);
	Member getMemberByEmail(String loginId);
	List<Member> getMembers(Long id);
}