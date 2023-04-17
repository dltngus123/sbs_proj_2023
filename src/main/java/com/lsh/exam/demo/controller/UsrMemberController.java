package com.lsh.exam.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsh.exam.demo.service.MemberService;
import com.lsh.exam.demo.utill.Ut;
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
	public Object dojoin(String loginId, String loginPw,String name, String nickname, String cellphoneNo, String email) {
	
		//if(loginId == null || loginId.trim().length()==0) loginid가 널 또는 앞뒤공백 제거후 0이거나
		if ( Ut.empty(loginId)) {
			return "loginId(을)를 입력해 주세요.";
		}
		
		if ( Ut.empty(loginPw)) {
			return "loginPw(을)를 입력해 주세요.";
		}
		
		if ( Ut.empty(name)) {
			return "name(을)를 입력해 주세요.";
		}
		
		if ( Ut.empty(nickname)) {
			return "nickname(을)를 입력해 주세요.";
		}
		
		if (Ut.empty(email)) {
			return "email(을)를 입력해 주세요.";
		}
		
		if ( Ut.empty(cellphoneNo)) {
			return "cellphoneNo(을)를 입력해 주세요.";
		}
		
		int id = memberService.join(loginId, loginPw, name, nickname,email,cellphoneNo);
		
		if (id == -1) {
			
			return "해당 로그인 아이디는 이미 사용중 입니다.";
		}
		
		Member member = memberService.getMemberById(id);
		
		return member;
	}
	
	@RequestMapping("/usr/member/getMembers")
	@ResponseBody
	public List<Member> getMembers() {
		return memberService.getMembers();
	}

}
