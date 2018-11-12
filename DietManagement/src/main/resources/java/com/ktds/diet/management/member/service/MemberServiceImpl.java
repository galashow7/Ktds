package com.ktds.diet.management.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ktds.diet.management.member.biz.MemberBiz;
import com.ktds.diet.management.member.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberBiz memberBiz;
	
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		return memberBiz.createNewMember(memberVO);
	}

	@Override
	public MemberVO readOneMember(MemberVO memberVO) {
		return memberBiz.readOneMember(memberVO);
	}

}
