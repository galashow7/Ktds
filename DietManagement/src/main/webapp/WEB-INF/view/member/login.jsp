<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />
 	<script type="text/javascript">
		

	$().ready(function() {
		$("#login").click(function() {
			 if( $("loginEmail").val() == "" ) {
				alert("이메일을 입력해 주세요.")
				$("email").focus()
				return;
			}
			else if( $("#password").val() == "" ) {
				alert("비밀번호 입력해 주세요")
				$("password").focus()
				return;
			}			
		    $("#loginForm").attr({
				"method": "post",             
				"action": "/DietManagement/member/login"
			})
			.submit();
		});
	});
</script>
			<h1> 로그인 </h1>
			<div>
				<c:if test= "${param.error eq '1' }">
					<article>
						<div class="error">
							ID 또는 Password가 맞지 않습니다.
						</div>
					</article>
				</c:if>
			<form:form id="loginForm" modelAttribute="uploaderVO" >
				<div>
					<input type="email" id="loginEmail" name="loginEmail" value="${memberVO.email}" placeholder="Email"/>
				</div>
				<div>
					<input type="password" id="password" name="password" value="${memberVO.password}" placeholder="PassWord"/>
				</div>
				<div>
					<input type="button" id="login" value="로그인" />
				</div>
		<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />
		</form:form>
		</div>