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
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public Object doJoin(String loginId, String loginPw,String name, String nickname, String cellphoneNo, String email) {
	
		//if(loginId == null || loginId.trim().length()==0) loginId가 널 또는 앞뒤공백 제거후 0이거나
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
			
			return Ut.f("해당 로그인 아이디(%s)는 이미 사용중 입니다.", loginId);
			//return "해당 로그인 아이디("+ loginId +")는 이미 사용중 입니다.";
		}
		
		if (id == -2) {
			
			return Ut.f("해당 이름(%s)과 이메일(%s)은 이미 사용중 입니다.", name, email);
			//return "해당 이름("+ name +")과 이메일("+ email +")은 이미 사용중 입니다.";
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
