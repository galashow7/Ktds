package com.ktds.diet.management.member.web;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.diet.management.member.service.MemberService;
import com.ktds.diet.management.member.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/index")
	public String viewIndexPage() {
		return "index";
	}	
	
	@GetMapping("member/regist")
	public String viewRegistNewMemberPage() {
		return "member/regist";
	}
	
	@PostMapping("member/check/duplicate")
	@ResponseBody //리턴되는 객체를 제이슨으로 바꿔서 전달
	public Map<String, Object> doCheckDuplicateEmail(
			@RequestParam String email) {
		
		Random random = new Random();
		
		Map<String, Object> result = new HashMap<>();
		result.put("status", "OK");
		result.put("duplicated", random.nextBoolean());
		return result;
	}
	
	@PostMapping("member/regist")
	public ModelAndView doMemberRegistAction( 
			@ModelAttribute MemberVO memberVO) {
		
		ModelAndView view = new ModelAndView("redirect:/member/login");
				
		boolean isSuccess = this.memberService.createNewMember(memberVO); 
		return view;
	}
	
	
	@GetMapping("member/login")
	public String viewMemberLoginPage() {
		return "member/login";
	}
	
	@PostMapping("member/login")
	public String doMemberloginAction( 
			@ModelAttribute MemberVO memberVO
			, HttpSession session
			) {
		
		ModelAndView view = new ModelAndView("redirect:/member/login");
		MemberVO loginMemverVO = this.memberService.readOneMember(memberVO);
		
		if( loginMemverVO != null ) {
			session.setAttribute("_USER_", loginMemverVO);
			return "redirect:/index";
		}
		else {
			return "redirect:/member/login?error=1";
		}
	}
}
