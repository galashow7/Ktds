package com.ktds.diet.management.member.service;

import com.ktds.diet.management.member.vo.MemberVO;

public interface MemberService {

	public boolean createNewMember(MemberVO memberVO);
	
	public MemberVO readOneMember(MemberVO memberVO);
	
}
