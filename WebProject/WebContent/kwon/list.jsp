<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String pageFile = request.getParameter("orderTab");
    if(pageFile==null){
    	pageFile ="ALL_ORDER";
    }
%>
</head>
<body>
	<div id="top">
	<table class="colTable" id="content_top">
		<tr>
			<td class="tleft" width="150px">MY쿠팡</td>
			<td class="tcenter" width="200px"><h6>미사용티켓</h6></td>		
			<td class="tcenter" width="150px"><h6>배송중</h6></td>		
			<td class="tcenter" width="150px"><h6>할인쿠폰</h6></td>		
			<td class="tcenter" width="150px"><h6>쿠팡캐시</h6></td>		
		</tr>
	</table>
	</div><!-- top끝 -->
	
	
	<div id="left">

	<h5>MY 쇼핑</h5>
	<p><a href="#">주문목록/배송조회</a></p>
	<p><a href="#">최소/반품/교환/환불내역</a></p>
	<p><a href="#">정기배송관리</a></p>
	<hr>
	
	<h5>MY 혜택</h5>
	<p><a href="#">할인쿠폰</a></p>
	<p><a href="#">쿠팡캐시/기프트카드</a></p>
	<hr>
		
	<h5>MY 활동</h5>
	<p><a href="#">문의하기</a></p>
	<p><a href="#">문의내역 확인</a></p>
	<p><a href="#">구매후기</a></p>
	<hr>
	
	<h5>MY 정보</h5>
	<p><a href="./Mypage.jsp?contentFile=checkCusPass">개인정보확인/수정</a></p>
	<p><a href="#">결제수단·로켓페이 관리</a></p>
	<p><a href="#">배송지 관리</a></p>
	
	</div><!-- left끝 -->
	
	
	<div id="center">
	<h3>주문목록/배송조회</h3>
	
	<table class="colTable">
	<tr class="orderlist-all">
	<td><a href="./Mypage.jsp?orderTab=ALL_ORDER">전체</a></td>	
	<td><a href="./Mypage.jsp?orderTab=DELIVERY_ORDER">배송상품</a></td>	
	<td><a href="./Mypage.jsp?orderTab=TRABEL_ORDER">여행상품</a></td>	
	<td><a href="./Mypage.jsp?orderTab=TICKET_ORDER">티켓상품</a></td>	
	</tr>
	</table>
	
	<table>
	<tr>
		<td>
			<jsp:include page='<%=pageFile+".jsp"%>'/>
		</td>
	</tr>	
	</table>	
	
	</div><!-- center끝 -->
	
	<div id="clear"></div><!-- footer가 올라오는것 방지 -->
</body>
</html>