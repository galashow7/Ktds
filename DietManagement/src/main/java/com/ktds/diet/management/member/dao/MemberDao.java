package com.ktds.diet.management.member.dao; 

import java.util.Map;

import com.ktds.diet.management.member.vo.MemberVO;

public interface MemberDao {

	public int insertNewMember(MemberVO memberVO);
	
	public MemberVO selectOneMember(MemberVO memberVO);
	
	public int updatePoint(Map<String, Object> params);
}
