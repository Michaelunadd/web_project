<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>����/����</title>
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
	<div class="top"><a href="testTop.jsp"><img src="img/br.png">Ŭ�� �� ���� ������ �̵�</a>	</div>
	<div class="header"><a href="testHeader.jsp"><img src="img/bullet.png"></a>Ŭ�� �� ��ǰ����Ʈ �������� �̵�</div>
	<div class="order_header">�ֹ�/����</div>
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
				<th scope="col">��ǰ ����</th>
				<th scope="col">�Ǹ���</th>
				<th scope="col">��ۺ�</th>
				<th scope="col">����</th>
				<th scope="col">�ֹ��ݾ�</th>
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
				<td>2��</td>
				<td>2,500��</td>
				<td>1��</td>
				<td>9,900��</td>
			</tr>
			<tr>
				<td>2
				</th>
				<td>3��</td>
				<td>2,500��</td>
				<td>1��</td>
				<td>9,900��</td>
			</tr>
			<tr>
				<td>3
				</th>
				<td>4��</td>
				<td>2,500��</td>
				<td>1��</td>
				<td>9,900��</td>
			</tr>
		</tbody>
	</table>
	
	<!-- ����� ���� -->
	<div class="delivery">
		<h3>����� ����</h3>
		<li>������ :&nbsp;&nbsp;<input type="text" size="5"></li>
		<li>����ó1 :&nbsp; <input type="text" maxlength=3 size="1px">- <input type="text" maxlength=4 size="2px"> - <input type="text" maxlength=4 size="2px"></li>
		<li>����ó2 :&nbsp; <input type="text" maxlength=3 size="1px">- <input type="text" maxlength=4 size="2px"> - <input type="text" maxlength=4 size="2px"></li>
		<li>����� �ּ� : <input type="text" maxlength="6" size="10" placeholder="�����ȣ">
		  <button><a href="https://www.epost.go.kr/search.RetrieveIntegrationNewZipCdList.comm">�����ȣ �˻�</a></button><br></li> 
			<p><input style="margin-left: 40px" type="text" placeholder="�뷫���� �ּ�" maxlength="500" size="100"><br></p>
			<p><input style="margin-left: 40px" type="text" placeholder="�� �ּ�" maxlength="500" size="100"><br></p>
			<br><input type="text" style="margin-left: 40px" placeholder="��û������ �����ּ���(�ִ� 50��)" maxlength="50" size="100;"></div>
	<!-- /����� ���� -->
			
	<!-- ������ -->
	<div class="wrap">
	<div class="pay"><h4>����â���� �̵�</h4>
	<button><a href="mo.jsp">����</a></button>
	
	</div>
	<div class="receipt"><h4>������ ĭ</h4></div>
	</div>
			
</body>
<footer class="footer">Ǫ���Դϴ�.</footer>
</html>