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

$("#btnDelete").click(()=>{
	let chkDelete = [];
	$("#teamCheck:checked").each(function(){
		chkDelete.push($(this).val());
	});
	
	$.ajax("/deletePlayer", {
		type: "DELETE",
		dataType: "json", // 응답 데이터
		data: JSON.stringify(chkDelete), // http body에 들고갈 요청 데이터
		headers: { // http header에 들고갈 요청 데이터
			"Content-Type": "application/json; charset=utf-8"
		}
	}).done((res) => {
		if (res.code == 1) {
			location.href = "/";
		} else {
			alert("삭제 실패, 아이디 패스워드를 확인해주세요");
		}
	});
	
});
</script>

<%@ include file="../layout/footer.jsp"%>