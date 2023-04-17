package com.lsh.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsh.exam.demo.service.MemberService;

@Controller
public class UsrMemberController {
	
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 액션 메서드 시작
	@RequestMapping("/usr/member/dojoin")
	@ResponseBody
	public String dojoin(String loginId, String loginPw,String name, String nickname, String cellphoneNo, String email) {
	
		memberService.join(loginId, loginPw, name, nickname,email,cellphoneNo);
		
		return "성공!";
	}

}
