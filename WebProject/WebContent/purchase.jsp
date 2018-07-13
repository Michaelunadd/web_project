<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>구매/결제</title>
<style>
body {
	margin: 0;
}

.top {
	background: aqua;
	height: 39px;
}

.header {
	background: white;
	height: 66px;
}

.order_header {
	height: 38px;
	background: gray;
	margin: auto;
	width: 1100px;
}

.order_table {
	border: 1px;
	border-color: red;
	background: fuchsia;
}

.table {
	border: 1px solid black;
	padding: 10px;
	background: purple;
	width: 1100px;
	margin: auto;
}

.delivery {
	background: yellow;
	height: 300px;
	margin: auto;
	width: 1100px;
}

.delivery li {
	margin-left: 40px;
}

.table td {text-align: center;}
.pay {
	height: 200px;
	background: orange;
	position: relative;
	width: 726px;
	float: left;
}
.wrap{
height: 300px;
margin: auto;
width: 1100px;
background: lime;
}
.receipt{
height: 300px;
text-align: center;
}
.pay{
height: 300px;
text-align: center;
}
.footer{
height: 100px;
background: silver;
}
</style>

</head>
<body>
	<div class="top"><a href="testTop.jsp"><img src="img/br.png">클릭 시 메인 페이지 이동</a>	</div>
	<div class="header"><a href="testHeader.jsp"><img src="img/bullet.png"></a>클릭 시 상품리스트 페이지로 이동</div>
	<div class="order_header">주문/결제</div>
	<table class="table">
		<colgroup>
			<col width="500">
			<col width="135">
			<col width="120">
			<col width="90">
			<col width="110">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">상품 정보</th>
				<th scope="col">판매자</th>
				<th scope="col">배송비</th>
				<th scope="col">수량</th>
				<th scope="col">주문금액</th>
			</tr>
		</thead>
	</table>
	
	<table class="table">
		<colgroup><col width="500">
			<col width="135">
			<col width="120">
			<col width="90">
			<col width="110">
		</colgroup>
		<tbody>
			<tr>
				<td><div class="product_info">
						<img src="img/cof.jpg">
					</div>
				</th>
				<td>2조</td>
				<td>2,500원</td>
				<td>1개</td>
				<td>9,900원</td>
			</tr>
			<tr>
				<td>2
				</th>
				<td>3조</td>
				<td>2,500원</td>
				<td>1개</td>
				<td>9,900원</td>
			</tr>
			<tr>
				<td>3
				</th>
				<td>4조</td>
				<td>2,500원</td>
				<td>1개</td>
				<td>9,900원</td>
			</tr>
		</tbody>
	</table>
	
	<!-- 배송지 정보 -->
	<div class="delivery">
		<h3>배송지 정보</h3>
		<li>수령인 :&nbsp;&nbsp;<input type="text" size="5"></li>
		<li>연락처1 :&nbsp; <input type="text" maxlength=3 size="1px">- <input type="text" maxlength=4 size="2px"> - <input type="text" maxlength=4 size="2px"></li>
		<li>연락처2 :&nbsp; <input type="text" maxlength=3 size="1px">- <input type="text" maxlength=4 size="2px"> - <input type="text" maxlength=4 size="2px"></li>
		<li>배송지 주소 : <input type="text" maxlength="6" size="10" placeholder="우편번호">
		  <button><a href="https://www.epost.go.kr/search.RetrieveIntegrationNewZipCdList.comm">우편번호 검색</a></button><br></li> 
			<p><input style="margin-left: 40px" type="text" placeholder="대략적인 주소" maxlength="500" size="100"><br></p>
			<p><input style="margin-left: 40px" type="text" placeholder="상세 주소" maxlength="500" size="100"><br></p>
			<br><input type="text" style="margin-left: 40px" placeholder="요청사항을 적어주세요(최대 50자)" maxlength="50" size="100;"></div>
	<!-- /배송지 정보 -->
			
	<!-- 영수증 -->
	<div class="wrap">
	<div class="pay"><h4>결제창으로 이동</h4>
	<button><a href="mo.jsp">결제</a></button>
	
	</div>
	<div class="receipt"><h4>영수증 칸</h4></div>
	</div>
			
</body>
<footer class="footer">푸터입니다.</footer>
</html>