<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>오늘 뭐 먹지?</title>
        <link rel="stylesheet" href="../resources/CSS/index.css">
        <link rel="stylesheet" href="../resources/CSS/event.css">
        <link rel="stylesheet" href="../resources/CSS/reset.css">
        
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
                        <p class="header-logo"><a href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/index.html">오늘<span id="logo-layer"> 뭐 </span>먹지?</a></p>
                    </div>
                    <!-- 네비게이션 -->
                    <nav>
                        <ul>
                            <!-- 메뉴표 -->
                            <li><a class="manu" href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/survice/manu.html">메뉴표</a></li>
                            <!-- 서비스 지역 -->
                            <li><a class="manu" href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/survice/service_area.html">서비스 지역</a></li>
                            <!-- 이벤트 -->
                            <li><a class="manu" href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/survice/event.html">이벤트</a></li>
                            <!-- 문의하기 -->
                            <li><a class="manu" href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/member/inquiry.html">문의하기</a></li>
                            <!-- 마이페이지 -->
                            <li><a class="manu" href="#">마이페이지</a></li>
                        </ul>
                    </nav>
                    <!-- 로그인/회원가입 -->
                    <div id="login">
                        <a href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/member/login.html">로그인</a><pre id="Space"> | </pre><a href="http://127.0.0.1:5500/%EC%98%A4%EB%8A%98%20%EB%AD%90%20%EB%A8%B9%EC%A7%80/member/join.html">회원가입</a></div>
                </div>
                <!-- 채팅 문의 -->
                <div class="aside">
                    <div id="chat">
                        <a href="#"><img class="img" src="../resources/images/chat.png" alt="문의"></a>
                    </div>
                </div>
            </header>

            <main>
                <!-- 진행중인 이벤트 -->
            <div id="event"><span>진행중인 event</span></div>
            <div class="event-layer">
                <!-- 첫 번째 이벤트 -->
                <div id="event1"><span>● event1 (6/19~6/25)</span></div>
                <div><a href="#"><img id="event1-summer" src="../resources/images/banner1.png" alt="삼계탕"></a></div>
            </div>
            <div class="event-layer">
                <!-- 두 번째 이벤트 -->
                <div id="event2"><span>● event2 (6/1~6/30)</span></div>
                <div><a href="#"><img id="event2-review" src="../resources/images/review_banner.png" alt="리뷰"></a></div>
            </div>
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