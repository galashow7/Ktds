<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <jsp:include page="/WEB-INF/view/common/layout/layout_header.jsp" />
 	<script type="text/javascript">
		

	$().ready(function() {
		$("#email").keyup(function(){
			// Ajax 요청
			$.post("/DietManagement/member/check/duplicate" // URL
					, {
						"email": $(this).val()  //Request parameter
						}
					, function(response) {      //Response Call back
						if ( response.duplicated ) {
							$("#email-error").slideDown(100);
						}
						else {
							$("#email-error").slideUp(100);
						}
					})
		})
		$("#uploader").click(function() {
			 if( $("#email").val() == "" ) {
				alert("이메일을 입력해 주세요.")
				$("email").focus()
				return;
			}
			else if( $("#password").val() == "" ) {
				alert("비밀번호 입력해 주세요")
				$("password").focus()
				return;
			}
			else if( $("#passwordCheck").val() == "" ) {
				alert("비밀번호 입력해 주세요")
				$("password").focus()
				return;
			}
			else if( $("#name").val() == "" ) {
				alert("이름을 입력해 주세요.")
				$("name").focus()
				return;
			}
			else if( $("#phone").val() == "" ) {
				alert("전화번호를 입력해 주세요.")
				$("phone").focus()
				return;
			}
			if( $("#password").val() != $("#passwordCheck").val()) {
				alert("비밀번호가 다릅니다.")
				return false;
			}
			
		    $("#createForm").attr({
				"method": "post",             
				"action": "/DietManagement/member/regist",
				"enctype": "multipart/form-data"
			})
			.submit();
		});
	});
</script>
			<h1> 회원가입 </h1>
			<hr>
		
			<form id="createForm" >
				
				<div>
					<input type="email" id="email" name="email" placeholder="Email" value="${memberVO.email}" />
				</div>
				<div id="email-error" style="display:none;">
					이 이메일은 사용할 수 없습니다.
				</div>
				<div>
					<input type="password" id="password" name="password" placeholder="PassWord" value="${memberVO.password}"/>
				</div>
				<div>
					<input type="password" id="passwordCheck" name="passwordCheck" placeholder="PasswordCheck"/>
				</div>
				<div>
					<input type="text" id="name" name="name" placeholder="Name" value="${memberVO.name}"/>
				</div>
				<div>
					<input type="tel" id="phone" name="phone" placeholder="Phone" value="${memberVO.phone}"/>
				</div>
				<div>
					<input type="button" id="uploader" value="완료" />
				</div>
			</form>
<jsp:include page="/WEB-INF/view/common/layout/layout_footer.jsp" />