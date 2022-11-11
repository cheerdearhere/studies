<%@page import="sw_shopping.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
request.setCharacterEncoding("UTF-8");
UserDto dto = (UserDto)request.getAttribute("userDto");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>join Page</title>
<!-- style file -->
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%@ include file="topmenu.jsp" %>
<section>
	<h4>쇼핑몰 회원정보 수</h4>
	<form action="userModify.do" method="post" name="modifyForm" id="modifyForm">
		<table>
			<tbody>
				<tr>
					<td>회원번호</td>
					<td>
						<input type="text" name="custno" value="<%= dto.getCustno() %>" readonly/>
					</td>
				</tr>
				<tr>
					<td>회원 성명</td>
					<td>
						<input type="text" name="custname" value="<%= dto.getCustname()%>"/>
					</td>
				</tr>
				<tr>
					<td>회원 전화</td>
					<td>
						<input type="text" name="phone" value="<%= dto.getPhone() %>"/>
					</td>
				</tr>
				<tr>
					<td>회원 주소</td>
					<td>
						<input type="text" name="address" value="<%= dto.getAddress() %>"/>
					</td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td>
						<input type="text" name="joindate" value="<%=dto.getJoindate() %>" readonly/>
					</td>
				</tr>
				<tr>
					<td>고객등급[A:VIP,B:일반,C:직원]</td>
					<td>
						<input type="text" name="grade" value="<%=dto.getGrade() %>"/>
					</td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td>
						<input type="text" name="city" value="<%= dto.getCity()%>"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<button class="btn" type="button" onclick="modify_submit()">수정</button>
						<button class="btn" type="button" onclick="location='list.do'">조회</button>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</section>
<%@ include file="footer.jsp" %>
<script>
function modify_submit(){
	let fm = document.getElementById("modifyForm");
	if(fm.custname.value==""){
		alert("회원 성명이 입력되지 않았습니다.");
		fm.custname.focus();
		return false;
	}
	if(fm.phone.value==""){
		alert("회원 전화가 입력되지 않았습니다.");
		fm.phone.focus();
		return false;
	}
	if(fm.address.value==""){
		alert("회원주소가 입력되지 않았습니다.");
		fm.address.focus();
		return false;
	}
	if(fm.grade.value==""){
		alert("회원 등급이 입력되지 않았습니다.");
		fm.grade.focus();
		return false;
	}
	if(fm.city.value==""){
		alert("도시코드가 입력되지 않았습니다.");
		fm.city.focus();
		return false;
	}
	alert("회원 정보 수정이 완료되었습니다.");
	fm.submit();
}
</script>
</body>
</html>