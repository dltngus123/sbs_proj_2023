package com.lsh.exam.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lsh.exam.demo.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor{
	@Autowired
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		// 이제는 Rq 객체가 자동으로 만들어지기 때문에 필요없음.
		 /* Rq rq = new Rq(req, resp, memberService);
		 * resp.setContentType("text/html; charset=UTF-8");
		 * //System.out.println("실행가능?"); req.setAttribute("rq", rq);
		 */

		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}

}
