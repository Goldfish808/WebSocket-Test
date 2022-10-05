<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<br />
	<h4 class="d-flex justify-content-end">선수등록</h4>
	<div class="d-flex justify-content-end">
		<div style="width: 800px">
			<form class="d-flex">
				<input class="form-control me-2" type="text" placeholder="선수이름" id="playername" required> <input
					class="form-control me-2" type="text" placeholder="포지션" id="position" required> 
					<select	class="form-select" id="teamId">
					<!-- 					<option value=1 >롯데</option> -->
					<!-- 					<option value=2>삼성</option> -->
					<!-- 					<option value=3>SK</option> -->
					<c:forEach var="teamList" items="${teamList}"><!-- 구단 갯수만큼만 반복하기 위해서 하나 Model 하나 더 했음 -->
						<option value="${teamList.id}">${teamList.teamname}</option>
					</c:forEach>
				</select> <br>
				  <button id="btnAdd" class="btn btn-primary" type="button">Join</button>
			</form>
		</div>
	</div>


	<label for="sel1" class="form-label">구단 선택:</label> 
	<select class="form-select form-select-lg" id="teamSelect" name="sellist1">
		<option value=0>전체보기</option>
		<c:forEach var="teamList" items="${teamList}">
			<option value="${teamList.id}" >${teamList.teamname}</option>
		</c:forEach>
	</select> <br>
	<form id="teamListContent">
	
		<table class="table table-striped">
			<thead id="nextTbody">
				<tr>
					<th>번호</th>
					<th>선수이름</th>
					<th>포지션</th>
					<th>구단</th>
					<th>홈</th>
					<th>삭제</th>
				</tr>
			</thead>

			<tbody id="teamSelectList">
				<c:forEach var="player" items="${player}">
					<tr>
						<td>${player.ROWNUM}</td>
						<td>${player.playername}</td>
						<td >${player.position}</td>
						<td><a href="/baseteam/${player.teamId}">${player.teamname}</a></td>
						<td>${player.stadiumname}</td>
						<td><input id="teamCheck" class="form-check-input" type="checkbox" value="${player.id}"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="d-flex justify-content-end">
			<button id="btnDelete" class="btn btn-danger " type="button">선수 삭제하기</button>
		</div>
	</form>
</div>

<script>
$("#teamSelect").change(()=>{ //셀렉트가 변경됐을 때의 리스너, (셀렉트 선택)
	sortView();
});
function sortView(){
	let teamId = $("#teamSelect option:selected").val();
	
	$.ajax("/find/"+teamId,{
		type: "GET",
		dataType: "json"
	}).done((res)=>{
		$("#teamSelectList").empty();
		for( i in res.data){
			console.log(res.data[i].teamId);	
			let q = $(
					'<tr><td>'+res.data[i].rownum+'</td>'+
					'<td>'+res.data[i].playername+'</td>'+
					'<td >'+res.data[i].position+'</td>'+
					'<td><a href="/baseteam/"'+res.data[i].teamId+'>'+res.data[i].teamname+'</a></td>' +
					'<td>'+res.data[i].stadiumname+'</td>' +
					'<td><input id="teamCheck" class="form-check-input" type="checkbox" value='+res.data[i].id+'></td></tr>'
			);
			$("#teamSelectList").append(q);
		}

	});
}

$("#btnDelete").click(()=>{
	playerDelete();
});
	function playerDelete(){
		let chkDelete = [];
		$("#teamCheck:checked").each(function(){
			chkDelete.push($(this).val());
		});
		if(chkDelete.length==0){
			alert("선택된 삭제 리스트가 없습니다");
			return;
		}
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
		
	}
	
	
	
	$("#btnAdd").click(() => {
		add();
	});
	
	function add() {			
		let data = {
			playername: $("#playername").val(),
			position: $("#position").val(),
			teamId: $("#teamId option:selected").val()
		};

		$.ajax("/add", {
			type: "POST",
			dataType: "json", // 응답 데이터
			data: JSON.stringify(data), // http body에 들고갈 요청 데이터
			headers: { // http header에 들고갈 요청 데이터
				"Content-Type": "application/json; charset=utf-8"
			}
		}).done((res) => {
			if (res.code == 1) {
				location.href = "/";
			} else {
				alert("선구 영입 실패, 아이디 패스워드를 확인해주세요");
			}
		});
	}
</script>

<%@ include file="../layout/footer.jsp"%>