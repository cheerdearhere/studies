<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"
	import="sw_shopping.dto.MoneyDto"
 %>
<% 
	request.setCharacterEncoding("UTF-8");
	ArrayList<MoneyDto> moneyList = (ArrayList<MoneyDto>)request.getAttribute("moneyList");	
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
	<h4>회원 매출 조회</h4>
	<table>
		<thead>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출액</th>
			</tr>
		</thead>
		<tbody>
		<%
			for(MoneyDto dto : moneyList){
		%>
			<tr>
				<td> 
					<%= dto.getCustno() %>
				</td>
				<td> <%= dto.getCustname() %></td>
				<td> <%= dto.getGrade() %> </td>
				<td> <%= dto.getMoney() %></td>
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