<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>서비스 결과 실패</title>
	</head>
	<body>
<!-- 		<h1>서비스 결과 실패!</h1> -->
<!-- 		회원가입 페이지로 다시 이동하는 그것 -->
		<script>
			const result = "${msg}"
			const url = "${url}";
			alert(result);
			location.href = url;
		</script>
	</body>
</html>