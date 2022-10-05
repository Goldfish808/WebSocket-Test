<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<br />
<form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>번호</th>
				<th>선수이름</th>
				<th>포지션</th>
				<th>구단</th>
				<th>홈</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="player" items="${player}">
				<tr>
					<td>${player.ROWNUM}</td>
					<td>${player.playername}</td>
					<td>${player.position}</td>
					<td><a href="/baseteam/${player.teamId}">${player.teamname}</a></td>
					<td>${player.stadiumname} </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</form>
</div>

<script>
</script>

<%@ include file="../layout/footer.jsp"%>