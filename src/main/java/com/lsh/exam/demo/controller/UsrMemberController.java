package com.lsh.exam.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsh.exam.demo.service.MemberService;
import com.lsh.exam.demo.vo.Member;

@Controller
public class UsrMemberController {
	
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 액션 메서드 시작
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public Member dojoin(String loginId, String loginPw,String name, String nickname, String cellphoneNo, String email) {
	
		int id = memberService.join(loginId, loginPw, name, nickname,email,cellphoneNo);
		
		Member member = memberService.getMemberById(id);
		
		return member;
	}
	
	@RequestMapping("/usr/member/getMembers")
	@ResponseBody
	public List<Member> getMembers() {
		return memberService.getMembers();
	}

}
