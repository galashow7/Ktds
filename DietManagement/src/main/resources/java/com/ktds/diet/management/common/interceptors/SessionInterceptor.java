package com.ktds.diet.management.common.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ktds.diet.management.member.dao.MemberDao;
import com.ktds.diet.management.member.vo.MemberVO;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("_USER_");
		if (member == null) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/member/login");
			return false;
		}
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		HttpSession session = request.getSession();
		
		MemberVO sessionUploaderVO = (MemberVO) session.getAttribute("_USER_");
		
		if( sessionUploaderVO != null ) {
			MemberVO uploaderVO = memberDao.selectOneMember(sessionUploaderVO);
			session.setAttribute("_USER_", uploaderVO);	
		}
		
	}
}
