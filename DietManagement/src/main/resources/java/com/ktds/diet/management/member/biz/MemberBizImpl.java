package com.ktds.diet.management.member.biz;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ktds.diet.management.member.dao.MemberDao;
import com.ktds.diet.management.member.vo.MemberVO;

@Component
public class MemberBizImpl implements MemberBiz{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean createNewMember(MemberVO memberVO) {
		return memberDao.insertNewMember(memberVO) > 0;
	}

	@Override
	public MemberVO readOneMember(MemberVO memberVO) {
		return memberDao.selectOneMember(memberVO);
	}

	@Override
	public boolean updatePoint(String email, int point) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		params.put("point", point);
		return memberDao.updatePoint(params) > 0;
	}

}
