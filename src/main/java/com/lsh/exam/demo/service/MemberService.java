package com.lsh.exam.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lsh.exam.demo.repository.MemberRepository;
import com.lsh.exam.demo.utill.Ut;
import com.lsh.exam.demo.vo.Member;
import com.lsh.exam.demo.vo.ResultData;

@Service
public class MemberService {
	private MemberRepository memberRepository;
	
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResultData join(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		
		//중복확인 oldMember 원래 있던 id
		Member oldMember = getMemberByLoginId(loginId);
		
		if( oldMember != null) {
			
			return ResultData.from("F-7", Ut.f("해당 로그인 아이디(%s)는 이미 사용중 입니다.", loginId));
		}
		
		//이름 + 이메일 중복체크
		 oldMember = getMemberByNameAndEmail(name, email);
		
		if( oldMember != null) {
			
			return ResultData.from("F-8", Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중 입니다.", name, email));
		}
		
		
		memberRepository.join( loginId, loginPw, name, nickname,email, cellphoneNo);
		
		int id = memberRepository.getLastInsertId();
		
		return ResultData.from("S-1", "회원 가입이 완료 되었습니다.", id);
		
	}
	
	//loginId 중복방지
	private Member getMemberByLoginId(String loginId) {
		
		return memberRepository.getMemberByLoginId(loginId);
	}
	
	//email&name 중복방지
	private Member getMemberByNameAndEmail(String name, String email) {
		
		return memberRepository.getMemberByNameAndEmail(name, email);
	}

	//특정 member
	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}

	//member전체
	public List<Member> getMembers() {
		return memberRepository.getMembers();
	}
	
	
}