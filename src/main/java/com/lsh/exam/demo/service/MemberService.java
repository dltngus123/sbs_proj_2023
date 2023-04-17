package com.lsh.exam.demo.service;

import org.springframework.stereotype.Service;

import com.lsh.exam.demo.repository.MemberRepository;

@Service
public class MemberService {
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public void join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		memberRepository.join( loginId, loginPw, name, nickname,email, cellphoneNo);
		
	}
	
	
}