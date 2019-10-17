<%@page import="com.weapon.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Funter的军火库</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
	</head>
	<body class="is-preload">

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
                        <a href="#welcome" class="icon fa-home"><span>欢迎界面</span></a>
						<a href="#list" class="icon fa-clipboard"><span>新建订单</span></a>
						<a href="#work" class="icon fa-shopping-basket"><span>浏览商品</span></a>
						<a href="#contact" class="icon fa-comment"><span>联系我们</span></a>
						<a href="#wechat" class="icon fa-server"><span>关于</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="welcome" class="panel intro">
								<header>
									<h1>${user.username}</h1>
									<p>今天要来点什么枪</p>
									<div class="col-12">
										<button type="submit" class="btn btn-default" onclick=" exitclick();">注销</button>
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-default" onclick=" userclick();">用户管理</button>
									</div>
									<div class="col-12">
										<button type="submit" class="btn btn-default" onclick=" listclick();">订单管理</button>
									</div>
								</header>
								<a href="#work" class="jumplink pic">
									<span class="arrow icon fa-chevron-right"><span>See my work</span></span>
									<img src="images/me.jpg" alt="" />
								</a>
							</article>
                        <!-- regis-->
                        <article id="list" class="panel">
                            <header>
                                <h2>订购信息</h2>
                            </header>
							<form role="form" action="add_p" method="post">
                                <div>
                                    <div class="row">
                                        <div class="col-6 col-12-medium">
                                            <input type="text" class="form-control" id="listusername" name="username" placeholder="用户名" />
                                        </div>
                                        <div class="col-6 col-12-medium">
                                            <input type="text" class="form-control" id="listweaponname" name="weaponname" placeholder="商品名" />
                                        </div>
                                        <div class="col-12">
                                            <input type="text" class="form-control" name="number" placeholder="数量" />
                                        </div>
                                        <div class="col-12">
                                            <textarea name="adress" class="form-control" placeholder="订购地址" rows="6"></textarea>
                                        </div>
                                        <div class="col-12">
											<input type="submit" class="btn btn-default" value="订购" />
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </article>
						<!-- Work -->
							<article id="work" class="panel">
								<header>
									<h2>请选购您的武器</h2>
								</header>
								<p>
									Funter的军火库，为您提供最优质的家门口军火库，居住在太阳系内的客户都可以享受5分钟送货上门服务
								</p>
								<section>
									<div class="row">
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked1()"><img src="images/5_56.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked2()"><img src="images/7_62.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked3()"><img src="images/9mm.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked4()"><img src="images/AK-47.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked5()"><img src="images/AWP.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked6()"><img src="images/grenades.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked7()"><img src="images/M16a4.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked8()"><img src="images/M24.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked9()"><img src="images/M416.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked10()"><img src="images/m1911.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked11()"><img src="images/马格南.jpg" alt=""></a>
										</div>
										<div class="col-4 col-6-medium col-12-small">
											<a href="#list" class="image fit" onclick="imageClicked12()"><img src="images/沙漠之鹰.jpg" alt=""></a>
										</div>
									</div>
								</section>
							</article>

						<!-- Contact -->
							<article id="contact" class="panel">
								<header>
									<h2>联系我们</h2>
								</header>
								<form action="#" method="post">
									<div>
										<div class="row">
											<div class="col-6 col-12-medium">
												<input type="text" name="name" placeholder="用户名" />
											</div>
											<div class="col-6 col-12-medium">
												<input type="text" name="email" placeholder="邮箱" />
											</div>
											<div class="col-12">
												<input type="text" name="subject" placeholder="标题" />
											</div>
											<div class="col-12">
												<textarea name="message" placeholder="内容" rows="6"></textarea>
											</div>
											<div class="col-12">
												<input type="submit" value="反馈信息" />
											</div>
										</div>
									</div>
								</form>
							</article>

                        <!-- Wecaht -->
                        <article id="wechat" class="panel">
                            <header>
                                <h2 align="center">关于</h2>
                            </header>

                            <h1 align="center">
                                Bulid By Funter
                            </h1>
                            <h3 align="center">
                                Version v1.0
                            </h3>
                            <h3 align="center">
                                课程设计作品
                            </h3>
                            <h4 align="center">
                                秉承娱乐精神，请勿对号入座，抄袭作业可耻
                            </h4>
                        </article>
			</div>
                <div>
                    <input id="admin" name="admin" type="hidden" value="${user.admin}"/>
                </div>

                    <!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; Funter的军火库.</li><li>Design: Funter</li>
						</ul>
						<ul class="copyright">
							<li>合作伙伴(并没有)</li>
						</ul>
					</div>

				<div>
					<a class="icon fa-youtube" ></a>
					<a class="icon fa-shield" ></a>
					<a class="icon fa-bitcoin" ></a>
					<a class="icon fa-inbox" ></a>
					<a class="icon fa-truck" ></a>
					<a class="icon fa-star" ></a>
				</div>


		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script>
			function imageClicked1(){
				//var weaponname[]={"5.56子弹","7.62子弹","9mm子弹","AK-47自动步枪","AWP狙击步枪","手雷","M16A4自动步枪","M24狙击步枪","M416自动步枪","m1911自动手枪","马格南手枪","沙漠之鹰手枪"}
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="5.56子弹";
			}
            function imageClicked2(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="7.62子弹";
            }
            function imageClicked3(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="9mm子弹";
            }
            function imageClicked4(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="AK-47自动步枪";
            }
            function imageClicked5(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="AWP狙击步枪";
            }
            function imageClicked6(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="手雷";
            }
            function imageClicked7(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="M16A4自动步枪";
            }
            function imageClicked8(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="M24狙击步枪";
            }
            function imageClicked9(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="M416自动步枪";
            }
            function imageClicked10(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="m1911自动手枪";
            }
            function imageClicked11(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="马格南手枪";
            }
            function imageClicked12(){
                document.getElementById('listusername').value="${user.username}";
                document.getElementById('listweaponname').value="沙漠之鹰手枪";
            }
            function exitclick(){
                window.self.location = "login.html";
            }
            function userclick(){
                var is_admin = document.getElementById("admin").value;
                if(is_admin == "admin"){
                    window.self.location = "userlistforpage.html";
                }
                else{
                    window.alert ("您不是管理员，无法访问管理员界面");
                }
			}
            function listclick(){
                var is_admin = document.getElementById("admin").value;
                if(is_admin == "admin"){
                    window.self.location = "weaponlist.html";
                }
                else{
                    window.alert ("您不是管理员，无法访问管理员界面");
                }
            }
			</script>
			</div>
	</body>
</html>