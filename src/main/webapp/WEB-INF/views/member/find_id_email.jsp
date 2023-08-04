<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>login</title>
        <link rel="stylesheet" href="/resources/css/index.css">
        <link rel="stylesheet" href="/resources/css/reset.css">
        <link rel="stylesheet" href="/resources/css/find_id_email.css">
        <link rel="stylesheet" href="/resources/css/find_id_phone.css">
    </head>
    <body>
        <div id="container">
            <header>
                <div id="header">
                    <!-- 쿠폰 -->
                    <div id="coupon">
                        <p id="header-coupon"><a href="#">지금 첫 주문하고, 5천원 할인 쿠폰 받기</a></p>
                    </div>
                    <!-- 로고 -->
                    <div id="logo">
                        <p class="header-logo"><a href="/index.jsp">오늘<span id="logo-layer"> 뭐 </span>먹지?</a></p>
                    </div>
                    <!-- 네비게이션 -->
                    <nav>
                        <ul>
                            <!-- 메뉴표 -->
                            <li><a class="manu" href="/WEB-INF/views/service/menu.jsp">메뉴표</a> </li>
                            <!-- 서비스 지역 -->
                            <li><a class="manu" href="/WEB-INF/views/service/service_area.jsp">서비스 지역</a> </li>
                            <!-- 이벤트 -->
                            <li><a class="manu" href="/WEB-INF/views/service/event.jsp">이벤트</a> </li>
                            <!-- 문의하기 -->
                            <li><a class="manu" href="/WEB-INF/views/member/inquiry.jsp">문의하기</a> </li>
                            <!-- 마이페이지 -->
                            <li><a class="manu" href="#">마이페이지</a> </li>
                        </ul>
                    </nav>
                    <!-- 로그인/회원가입 -->
                    <div id="login">
                        <a href="/WEB-INF/views/member/login.jsp">로그인</a><pre id="Space"> | </pre><a href="/WEB-INF/views/member/join.jsp">회원가입</a></div>
                </div>
                <!-- 채팅 문의 -->
                <div class="aside">
                    <div id="chat">
                        <a href="#"><img class="img" src="/resources/images/chat.png" alt="문의"></a>
                    </div>
                </div>
            </header>

            <main>
                <!-- 아이디 찾기 -->
                <form action="/member/findId.do" method="post">
	                <div class="findId">
	                    <h2>아이디 찾기</h2>
	                    <div id="choiceWay">
	                        <!-- 휴대폰 인증 -->
	                        <div id="phoneCer">
	                            <a href="/WEB-INF/views/member/find_id_phone.jsp"><h3>휴대폰 인증</h3></a>
	                        </div>
	                        <!-- 이메일 인증 -->
	                        <div id="emailCer">
	                            <a href="/WEB-INF/views/member/find_id_email.jsp"><h3>이메일 인증</h3></a>
	                        </div>
	                        <hr>
	                    </div>
	                    <!-- 이름 -->
	                    <div id="userName">
	                        <h3>이름</h3>
	                        <input type="text" name="userName" id="userName" placeholder="이름을 입력해주세요">
	                    </div>
	                    <!-- 이메일 -->
	                    <div id="usernumber">
	                        <h3>이메일</h3>
	                        <input type="text" name="userEmail" id="userEmail" placeholder="이메일을 입력해주세요">
	                    </div>
	                    <!-- 인증번호 받기 -->
	                    <div class="number">
	                        <input id="number" type="submit" value="인증번호 보내기">
	                    </div>
	                </div>
                </form>
            </main>

            <footer>
                <div id="footer-layer1">
                    <!-- 고객센터 -->
                    <div class="service">
                        <h2 id="service-layer1">고객센터 : 1588-1588</h2>
                        <p id="service-layer2"><small>고객센터 운영시간 : 평일 10:00 ~ 16:00</small></p>
                    </div>
                    <!-- 회사 정보 -->
                    <div class="info">
                        <p><span>회사명 : 오늘 뭐 먹지</span></p>
                        <p>본사주소 : 서울시</p>
                        <p>물류 : 경기도</p>
                        <p>대표 : 김이름</p>
                        <p>사업자등록번호 : 000-00-00000</p>
                        <p>통신판매업신고 : 0000-서울종로-0000호</p>
                        <p>이메일 : email@email.com</p>
                    </div>
                </div>
                <div id="footer-layer2">
                    <!-- 약관 -->
                    <div id="report">
                        <ul class="report-layer">
                            <li><a href="#">회사소개</a></li>
                            <li><a href="#">이용약관</a></li>
                            <li id="secret-info"><a href="#">개인정보처리방침</a></li>
                        </ul>
                    </div>
                </div>
            </footer>
        </div>
    </body>
</html>