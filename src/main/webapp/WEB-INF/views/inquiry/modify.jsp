<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>문의 수정</title>
	</head>
	<body>
		<h1>문의 수정</h1>
		<form action="/inquiry/modify.do" method="post">
			<input type="hidden" name="inquiryNo" value="${inquiry.inquiryNo }">
			<fieldset>
				<legend>문의 수정하기</legend>
				<ul>
					<li>
						<label>제목</label> 
						<input type="text" name="inquirySubject" value="${inquiry.inquirySubject }">
					</li>
					<li>
						<label>내용</label>
						<textarea rows="30" cols="40" name="inquiryContent">${inquiry.inquiryContent }</textarea>
					</li>
				</ul>
			</fieldset>
			<div>
				<input type="submit" value="수정">
				<input type="reset" value="초기화">
			</div>
		</form>
	</body>
</html>