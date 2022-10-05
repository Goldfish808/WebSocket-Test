<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Blog</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" rel="stylesheet">
</head>
<body>

	<!-- 세션에 담은건 키값이 sessionScope 로 지정되어있음 -->
	<h1>${sessionScope.principal.username}</h1>
	<!-- username 이 나오면 인증 된거 -->

	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/">BaseBall</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
				<ul class="navbar-nav">

					<li class="nav-item"><a class="nav-link" href="/">선수</a></li>
					<li class="nav-item"><a class="nav-link" href="#">경기장</a></li>
					<li class="nav-item"><a class="nav-link" href="#">구단</a></li>
					<li class="nav-item"><a class="nav-link" href="#">퇴출</a></li>

				</ul>
			</div>
		</div>
	</nav>