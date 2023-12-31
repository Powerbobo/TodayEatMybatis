<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
	<!-- head -->
	<jsp:include page="/WEB-INF/views/include/head_inquiry.jsp"></jsp:include>
	<link rel="stylesheet" href="/resources/css/inquiry.css">
    <body>
        <div id="container">
	        <!-- header -->
			<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
            <main>
            <div>
            	<button onclick="ClickRegister();" type="button" id="inquiryBtn">1:1문의 등록하기</button>
            </div>
	            <c:if test="${ userId eq null }">
	            	<script>
		            	alert("로그인을 해주세요");
		    			location.href = "/member/login.do";
	            	</script>
	            </c:if>
	            <c:if test="${ userId ne null }">
		            <form action="/inquiry/list.do" method="post">
		                    <!-- 문의 목록 -->
		                    <div id="list"><span>문의 목록</span></div>
		                    <!-- 문의 등록하기 -->
		                    <hr>
	                        <table>
	                        	<thead>
	                         	   <tr>
	                            	    <th class="list-layer">번호</th>
	                          	     <th class="list-layer">문의 날짜</th>
	                         	       <th class="list-layer">제목</th>
	                         	       <th class="list-layer">답변 여부</th>
	                       	     </tr>
	                    	    </thead>
	                    	    <tbody>
	                    	    	<c:forEach var="inquiry" items="${ iList }">
		                        		<tr>
		                          		 	<td class="number">${ inquiry.inquiryNo }</td>
		                          		 	<td class="date">${ inquiry.inquiryDate }</td>
		                        			<td class="title"><a href="/inquiry/detail.do?inquiryNo=${ inquiry.inquiryNo }">${ inquiry.inquirySubject }</a></td>
		                       				<td class="answer">${ inquiry.inquiryYN }</td>
		                          		</tr>
	                          		</c:forEach>
	                          		<tr>
	                          			<td colspan="5" align="center">
	                          			${pageNavi}
	                          		</tr>
	                        	</tbody>
	                        </table>
		            </form>
	            </c:if>
            </main>
			<!-- footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
        </div>
        <script>
        	function ClickRegister() {
        		location.href = '/inquiry/insert.do';
        	}
        </script>
    </body>
</html>