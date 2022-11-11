<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
	import="sw_shopping.dto.UserDto"
 %>
<% 
	request.setCharacterEncoding("UTF-8");
	ArrayList<UserDto> userList = (ArrayList<UserDto>)request.getAttribute("userList");	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert Title</title>
<!-- style file -->
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<%@ include file="topmenu.jsp" %>
<section>
	<h4>회원 목록 조회/수정</h4>
	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(UserDto dto : userList){
		%>
			<tr>
				<td> 
					<a href="userModifyFrm.do?custno= <%= dto.getCustno() %>"><%= dto.getCustno() %></a>
				</td>
				<td> <%= dto.getCustname() %></td>
				<td> <%= dto.getPhone() %></td>
				<td> <%= dto.getAddress() %></td>
				<td> <%= dto.getJoindate() %></td>
				<td> <%= dto.getGrade() %> </td>
				<td> <%= dto.getCity() %></td>
			</tr>		
		<% 
			}
		%>
		</tbody>
	</table>
</section>
<%@ include file="footer.jsp" %>
<script>

</script>
</body>
</html>