package com.lsh.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsh.exam.demo.repository.MemberRepository;
import com.lsh.exam.demo.vo.Member;

@Service
public class MemberService {
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public int join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		memberRepository.join( loginId, loginPw, name, nickname,email, cellphoneNo);
		
		return memberRepository.getLastInsertId();
		
	}
	
	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}


	public List<Member> getMembers() {
		return memberRepository.getMembers();
	}
	
	
}