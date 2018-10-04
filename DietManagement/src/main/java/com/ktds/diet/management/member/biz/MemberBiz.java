package com.ktds.diet.management.member.biz;

import com.ktds.diet.management.member.vo.MemberVO;

public interface MemberBiz {

	public boolean createNewMember(MemberVO memberVO);
	
	public MemberVO readOneMember(MemberVO memberVO);
	
	public boolean updatePoint(String email, int point);
}
