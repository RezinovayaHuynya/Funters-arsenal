
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>修改</title>

	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="assets/css/main.css" />
	<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>


	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="is-preload" >
<!-- ajax请求服务器，拿到json，解析，展示 -->

<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/browser.min.js"></script>
<script src="assets/js/breakpoints.min.js"></script>
<script src="assets/js/util.js"></script>
<script src="assets/js/main.js"></script>
<!-- Wrapper-->
<div id="wrapper">

	<!-- Nav -->
	<nav id="nav">
		<a href="#login" class="icon fa-address-book"></a>
	</nav>

	<!-- Main -->
	<div id="main">

		<!-- login -->
		<article id="login" class="panel">

			<div class="container">
				<div class="row clearfix">
					<div class="col-md-12 column">
						<h3>
							修改订单信息
						</h3>
						<form role="form" action="edit_p" method="post">
							<input id="id" name="id" type="hidden" value="${product.id}"/>
							<div class="form-group">
								<label >用户名</label><input type="text" class="form-control" id="username" name="username" value="${product.username}" />
							</div>
							<div class="form-group">
								<label >武器名</label><input type="text" class="form-control" id="weaponname" name="weaponname" value="${product.weaponname}"  />
							</div>
							<div class="form-group">
								<label >数量</label><input type="text" class="form-control" id="number" name="number" value="${product.number}" />
							</div>
							<div class="form-group">
								<label >地址</label><input type="text" class="form-control" id="adress" name="adress" value="${product.adress}" />
							</div>

							<button type="submit" class="btn btn-default">保存</button>
						</form>
					</div>
				</div>
			</div>
		</article>
	</div>
</div>
</body>
</html>