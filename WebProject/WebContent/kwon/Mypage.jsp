<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>

	#wrap{
		margin:0;
	}
	
	/* header 시작 */
	#header a{
		float:left;
	}
	
	
	.frm table{
		margin-left:20px;
		margin-top:20px;
		float: left;
		border: 2px solid #6799FF;
	}
	
	.logo_img{
		width: 140px;
	}
	
	.mypage_img{
		margin-left:20px;
		padding-top:20px;
		width:40px;
	}
	
	.basket_img{
		margin-left:20px;
		padding-top:15px;
		width:45px;
	}
	
	/* header 끝 */
	
	/* content 시작 */
	#content{
		height: 700px;
	}
	
	#top{
		margin: 0 auto;
	}	
	
	.colTable, .colTable td{
		border: 1px solid black;
		border-collapse:collapse;
	}
	
	#content_top{
		color:#fff;
		text-align: center;
	}
	
	.orderlist-all td{
		padding: 15px;
		width: 130px;
		text-align: center;
	}
	
		
	.tleft{
		font-size: 25px;
		background: #286DB4;
	}	
	
	.tcenter{
		background: #9DCFFF;
	}

	#left{
		width: 130px;
		border:1px solid #999;
		padding:10px;
		float: left;
	}
	#left a{
		text-decoration: none;
		font-size: 10px;
		color: #000;
	}
	
	#center{
		margin-left:170px;	
	}
	
	#center a{
		text-decoration: none;
		font-size: 15px;
		font-weight: bold;
		color: #000;
	}
	
	/* content 끝 */
	
	/* footer 시작 */
	#footer{
		font-size: 10px;
	}
	
	#footer a{
		text-decoration: none;
		color: #000;
	}
	#footer span{
		font-size: 20px;
	}
	#footer img{
		width: 100px;
	}
	#certification td{
		padding:20px;
	}
	#certification img{
		float:left;
		width: 30px;
	}
	#footer p{
	padding: 20px;
	background: #4C4C4C;
	color: #BDBDBD;
	}
	#footinfo{
		float:left;
	}
	#footer p img{
		width: 50px;
	}
	/* footer 끝 */
	
	#clear{
		clear:both;
	}
	
</style>

<%
	String contentFile = request.getParameter("contentFile");
    if(contentFile==null){
    	contentFile ="list";
    }
%>

</head>
<body>
<div id="wrap">
	<div id="header">
		<a href="#"><img class="logo_img" src="images/cup_logo.jpg" alt="logo"></a>
		<form action="#" class="frm">
			<table>
			<tr>
			<td>
			<select>
				<option value="#">전체</option>
			</select>
			</td>
			<td>			
			<input type="text">
			<input type="submit" value="검색">
			</td>
			</tr>
			</table>
		</form>
		<a href="#"><img class="mypage_img" src="images/mypage_logo.png"></a>
		<a href="#"><img class="basket_img" src="images/basket.png"></a>
	</div><!-- header 끝 -->
	<div id="clear"></div>
	
	<hr>
	
	<table><!-- 비밀번호 수정 구현위해  table 로 묶음 -->
	<tr><td>

	<div id="content">
	
	<jsp:include page='<%=contentFile+".jsp"%>'/>

	</div><!-- content 끝 -->

	</td></tr>
	</table><!-- 비밀번호 수정 시 컨텐츠부분을 바꾸기 위해 table로 묶음 -->
	
	
	<div id="footer">
	<hr>
	&nbsp;&nbsp;&nbsp; 
	<a href="#">인재채용</a> &nbsp;| &nbsp;&nbsp;
	<a href="#">입점/제휴문의</a> &nbsp;| &nbsp;&nbsp;
	<a href="#">공지사항</a> &nbsp;| &nbsp;&nbsp;
	<a href="#">고객의소리</a> &nbsp;| &nbsp;&nbsp;
	<a href="#">이용약관</a> &nbsp;| &nbsp;&nbsp;
	<b><a href="#">개인정보 처리방침</a></b> &nbsp;| &nbsp;&nbsp;
	<a href="#">신뢰관리센터</a>
	<hr>
	
	<table >
	<tr>
	
	<td>
	<a href="#/"><img src="images/cup_logo_gray.jpg"></a>
	</td>
	
	<td>
	쿠팡(주) | 대표이사: 권영준	<br>
	서울시 송파구 송파대로 123	<br>
	사업자 등록번호: 777-00-777777		<br>
	통신판매업신고: 2017-서울송파-0680	<br>
	<a href="#">사업자 정보확인</a>
	</td>
	
	<td>	
	<a href="#cusCenter">
	<b>365고객센터</b> | 전자금융거래분쟁처리담당<br>
	<span>1577-7011</span>
	</a><br>
	서울특별시 금천구 두산로 00 B, 77층<br>
	Fax: 02-0000-7777 | email: help@goodpang.com
	</td>
	
	<td>
	<b>우리은행 채무지급보증 안내</b>		<br>
	 당사는 고객님이 현금 결제한 금액에 대해 <br>
	 우리은행과 채무지급보증 계약을 체결하여 <br> 
	 안전거래를 보장하고 있습니다.			<br>
	<a href="#">서비스 가입사실 확인</a>
	</td>
	</tr>
	</table>
	
	<hr>
	
	<table >
		<tr id="certification">
			<td>
			<img src="images/certification/ISMS.jpg">
			정보관리체계<br>
			ISMS인증획득
			</td>
			<td>
			<img src="images/certification/PIMS.jpg">
			개인정보보호 관리체계<br>
			PIMS 인증획득
			</td>
			<td>
			<img src="images/certification/ISO27001.jpg">
			정보보안 국제표준<br>
			ISO27001인증획득
			</td>
			<td>
			<img src="images/certification/ePRIVACY.png">
			개인정보보호우수사이트<br>
			ePRIVACY인증획득
			</td>
		</tr>
	</table>
	
	<p id="footinfo">
	개별 판매자가 등록한 마켓플레이스(오픈마켓) 상품에 대한 광고, 상품주문, 배송, 
	및 환불의 의무와 책임은 각 판매자가 부담하고,<br>
	이에 대하여 굿팡은 통신판매중개자로서 통신팜의 당사자가 아니므로 일체 책임을 지지 않습니다.
	</p>
	<p>
		<a href="#facebookpage"><img src="images/sns/facebook.jpg"></a>
		<a href="#nblogpage"><img src="images/sns/nblog.png"></a> 
		<a href="#instapage"><img src="images/sns/insta.png"></a> 
	</p>	
	
	</div><!-- footer 끝 -->
</div><!-- wrap  -->	
</body>
</html>