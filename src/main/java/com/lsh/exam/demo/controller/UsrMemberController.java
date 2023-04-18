package com.lsh.exam.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lsh.exam.demo.service.MemberService;
import com.lsh.exam.demo.utill.Ut;
import com.lsh.exam.demo.vo.Member;
import com.lsh.exam.demo.vo.ResultData;

@Controller
public class UsrMemberController {
	
	private MemberService memberService;
	
	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	// 액션 메서드 시작
	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData<Member> doJoin(String loginId, String loginPw,String name, String nickname, String cellphoneNo, String email) {
	
		//if(loginId == null || loginId.trim().length()==0) loginId가 널 또는 앞뒤공백 제거후 0이거나
		if ( Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId(을)를 입력해 주세요.");
		}
		
		if ( Ut.empty(loginPw)) {
			return ResultData.from("F-2", "loginPw(을)를 입력해 주세요.");
		}
		
		if ( Ut.empty(name)) {
			return ResultData.from("F-3", "name(을)를 입력해 주세요.");
		}
		
		if ( Ut.empty(nickname)) {
			return  ResultData.from("F-4", "nickname(을)를 입력해 주세요.");
		}
		
		if (Ut.empty(email)) {
			return ResultData.from("F-5", "email(을)를 입력해 주세요.");
		}
		
		if ( Ut.empty(cellphoneNo)) {
			return ResultData.from("F-6", "cellphoneNo(을)를 입력해 주세요.");
		}
		
		//성공시S-1,회원가입 완료됨 MSG ,새로운 회원 번호 data1
		ResultData<Integer> joinRd = memberService.join(loginId, loginPw, name, nickname,email,cellphoneNo);
		
		if (joinRd.isFail()) {
			return (ResultData)joinRd;
		}
		
		Member member = memberService.getMemberById(joinRd.getData1());
		
		return ResultData.newData(joinRd, member);
	}
	
	@RequestMapping("/usr/member/getMembers")
	@ResponseBody
	public List<Member> getMembers() {
		return memberService.getMembers();
	}

}
