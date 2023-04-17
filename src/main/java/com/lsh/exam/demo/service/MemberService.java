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
		
		//중복확인 oldmember 원래 있던 id
		Member oldMember = getMemberByLoginId(loginId);
		
		if( oldMember != null) {
			
			return -1;
		}
		
		memberRepository.join( loginId, loginPw, name, nickname,email, cellphoneNo);
		
		return memberRepository.getLastInsertId();
		
	}
	
	//중복방지
	private Member getMemberByLoginId(String loginId) {
		
		return memberRepository.getMemberByLoginId(loginId);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}


	public List<Member> getMembers() {
		return memberRepository.getMembers();
	}
	
	
}