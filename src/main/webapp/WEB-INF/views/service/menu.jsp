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
        <link rel="stylesheet" href="../resources/CSS/menu.css">
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
                <div class="day">
                    <div id="mon"><span>6/12 (월)</span></div>
                    <div id="day1">
                        <!-- 월요일 메뉴 -->
                        <div class="manuMon">
                            <div id="manuMon-layer1">
                                <!-- 메뉴1 사진 -->
                                <a href="#"><img src="../resources/images/food1.png" alt="음식1"></a>
                                <!-- 메뉴1 이름 -->
                                <div class="layer1-text1"><span>얼큰짬뽕 덮밥</span></div>
                                <!-- 메뉴1 반찬 -->
                                <div class="layer1-text2"><p>얇은 단무지</p></div>
                                <div class="layer1-text2"><p>모둠 컵 과일</p></div>
                            </div>
                                
                        </div>
                        <div class="manuMon">
                            <div id="manuMon-layer2">
                                <!-- 메뉴2 사진 -->
                                <a href="#"><img src="../resources/images/food2.png" alt="음식2"></a>
                                <!-- 메뉴2 이름 -->
                                <div class="layer2-text1">간장버터 덮밥</div>
                                <!-- 메뉴2 반찬 -->
                                <div class="layer2-text2">볶음김치</div>
                                <div class="layer2-text2">요하임85g 블루베리맛</div>
                            </div>
                        </div>
                        <div class="manuMon">
                            <div id="manuMon-layer3">
                                <!-- 메뉴3 사진 -->
                                <a href="#"><img src="../resources/images/food3.png" alt="음식3"></a>
                                <!-- 메뉴3 이름 -->
                                <div class="layer3-text1">소불고기 규동</div>
                                <!-- 메뉴3 반찬 -->
                                <div class="layer3-text2">미니반찬세트(어채조림&고구마샐러드)</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="day">
                    <div id="tue"><span>6/13 (화)</span></div>
                    <div>
                        <div id="day1">
                            <!-- 화요일 메뉴 -->
                            <div class="manuTue">
                                <div id="manuTue-layer1">
                                    <!-- 메뉴4 사진 -->
                                    <a href="#"><img src="../resources/images/food4.png" alt="음식4"></a>
                                    <!-- 메뉴4 이름 -->
                                    <div class="layer1-text3"><span>곤드레나물 덮밥</span></div>
                                    <!-- 메뉴4 반찬 -->
                                    <div class="layer1-text4"><p>사골 미역국</p></div>
                                </div>
                                    
                            </div>
                            <div class="manuTue">
                                <div id="manuTue-layer2">
                                    <!-- 메뉴5 사진 -->
                                    <a href="#"><img src="../resources/images/food5.png" alt="음식5"></a>
                                    <!-- 메뉴5 이름 -->
                                    <div class="layer2-text3">제육 강된장 비빔밥</div>
                                    <!-- 메뉴5 반찬 -->
                                    <div class="layer2-text4">사골 미역국</div>
                                    <div class="layer2-text4">볶음김치</div>
                                </div>
                            </div>
                            <div class="manuTue">
                                <div id="manuTue-layer3">
                                    <!-- 메뉴6 사진 -->
                                    <a href="#"><img src="../resources/images/food6.png" alt="음식6"></a>
                                    <!-- 메뉴6 이름 -->
                                    <div class="layer3-text3">화이트 트러플오일 크림 파스타</div>
                                    <!-- 메뉴6 반찬 -->
                                    <div class="layer3-text4">데리야끼 닭가슴살 샌드위치(1/2)</div>
                                    <div class="layer3-text4">미니피클</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="day">
                    <div id="wed"><span>6/14 (수)</span></div>
                    <div>
                        <div id="day1">
                            <!-- 수요일 메뉴 -->
                            <div class="manuWed">
                                <div id="manuWed-layer1">
                                    <!-- 메뉴7 사진 -->
                                    <a href="#"><img src="../resources/images/food7.png" alt="음식7"></a>
                                    <!-- 메뉴7 이름 -->
                                    <div class="layer1-text5"><span>데미 함박스테이크</span></div>
                                    <!-- 메뉴7 반찬 -->
                                    <div class="layer1-text6"><p>단호박 샐러드</p></div>
                                    <div class="layer1-text6"><p>꽈리고추멸치볶음</p></div>
                                    <div class="layer1-text6"><p>볶음김치</p></div>
                                </div>
                                    
                            </div>
                            <div class="manuWed">
                                <div id="manuWed-layer2">
                                    <!-- 메뉴8 사진 -->
                                    <a href="#"><img src="../resources/images/food8.png" alt="음식8"></a>
                                    <!-- 메뉴8 이름 -->
                                    <div class="layer2-text5">고소한 잡채 덮밥</div>
                                    <!-- 메뉴8 반찬 -->
                                    <div class="layer2-text6">썰은 배추김치(60g)</div>
                                    <div class="layer2-text6">모둠 컵과일</div>
                                </div>
                            </div>
                            <div class="manuWed">
                                <div id="manuWed-layer3">
                                    <!-- 메뉴9 사진 -->
                                    <a href="#"><img src="../resources/images/food9.png" alt="음식9"></a>
                                    <!-- 메뉴9 이름 -->
                                    <div class="layer3-text5">군산 고추 짜장덮밥</div>
                                    <!-- 메뉴9 반찬 -->
                                    <div class="layer3-text6">얇은 단무지</div>
                                    <div class="layer3-text6">동아오츠카 나랑드사이다 파인애플</div>
                                </div>
                            </div>
                        </div>
                    </div>
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