<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>旻星</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
	<link rel="stylesheet" href="/assets/css/ace.min.css" />
	<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
	<style>  
        body{  
            background: #FFFFFF;  
        }  
        #l_div{
        	background-color:#F2F2F2;
        }
    </style> 
</head>

<body>
	<div class="login-container">
		<h1><img src="/img/tsjinronglogo.jpg"></h1>
		<div class="center">
			<h1>
				<i class="icon-leaf green"></i>
				<span class="red">Auth<small>(v2.0.0)</small></span>
			</h1>
			<h4 class="blue">&copy; 旻星科技</h4>
		</div>
		<div class="space-6"></div>
		<div class="position-relative">
			<div id="login-box" class="login-box visible widget-box no-border">
				<div class="widget-body" id="l_div">
					<div class="widget-main">
						<h4 class="header blue lighter bigger">
							<i class="icon-coffee green"></i>
							请输入您的信息
						</h4>
						<div class="space-6"></div>
						<form>
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" class="form-control" placeholder="Username" />
										<i class="icon-user"></i>
									</span>
								</label>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="Password" />
										<i class="icon-lock"></i>
									</span>
								</label>
								<div class="space"></div>

								<div class="clearfix">
									<label class="inline">
										<input type="checkbox" class="ace" />
										<span class="lbl">记住密码</span>
									</label>

									<button type="button" class="width-35 pull-right btn btn-sm btn-primary" id="login">
										<i class="icon-key"></i>
										登录
									</button>
								</div>
								<div class="space-4"></div>
							</fieldset>
						</form>

						<!-- <div class="social-or-login center">
							<span class="bigger-110">Or Login Using</span>
						</div>

						<div class="social-login center">
							<a class="btn btn-primary">
								<i class="icon-facebook"></i>
							</a>

							<a class="btn btn-info">
								<i class="icon-twitter"></i>
							</a>

							<a class="btn btn-danger">
								<i class="icon-google-plus"></i>
							</a>
						</div> -->
					</div>

					<div class="toolbar clearfix">
						<div>
							<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
								<i class="icon-arrow-left"></i>
								找回密码
							</a>
						</div>

						<div>
							<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
								权限申请
								<i class="icon-arrow-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>

			<!-- 找回密码 -->
			<!-- <div id="forgot-box" class="forgot-box widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header red lighter bigger">
							<i class="icon-key"></i>
							Retrieve Password
						</h4>

						<div class="space-6"></div>
						<p>
							Enter your email and to receive instructions
						</p>

						<form>
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="email" class="form-control" placeholder="Email" />
										<i class="icon-envelope"></i>
									</span>
								</label>

								<div class="clearfix">
									<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
										<i class="icon-lightbulb"></i>
										Send Me!
									</button>
								</div>
							</fieldset>
						</form>
					</div>/widget-main

					<div class="toolbar center">
						<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
							Back to login
							<i class="icon-arrow-right"></i>
						</a>
					</div>
				</div>
			</div> -->


			<!-- 注册 -->
			<!-- <div id="signup-box" class="signup-box widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header green lighter bigger">
							<i class="icon-group blue"></i>
							New User Registration
						</h4>

						<div class="space-6"></div>
						<p> Enter your details to begin: </p>

						<form>
							<fieldset>
								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="email" class="form-control" placeholder="Email" />
										<i class="icon-envelope"></i>
									</span>
								</label>

								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="text" class="form-control" placeholder="Username" />
										<i class="icon-user"></i>
									</span>
								</label>

								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="Password" />
										<i class="icon-lock"></i>
									</span>
								</label>

								<label class="block clearfix">
									<span class="block input-icon input-icon-right">
										<input type="password" class="form-control" placeholder="Repeat password" />
										<i class="icon-retweet"></i>
									</span>
								</label>

								<label class="block">
									<input type="checkbox" class="ace" />
									<span class="lbl">
										I accept the
										<a href="#">User Agreement</a>
									</span>
								</label>

								<div class="space-24"></div>

								<div class="clearfix">
									<button type="reset" class="width-30 pull-left btn btn-sm">
										<i class="icon-refresh"></i>
										Reset
									</button>

									<button type="button" class="width-65 pull-right btn btn-sm btn-success">
										Register
										<i class="icon-arrow-right icon-on-right"></i>
									</button>
								</div>
							</fieldset>
						</form>
					</div>

					<div class="toolbar center">
						<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
							<i class="icon-arrow-left"></i>
							Back to login
						</a>
					</div>
				</div>
			</div> -->
		</div>
	</div>
	<script src="/jquery/jquery-1.8.2.min.js"></script>
	<script src="/js/login/login.js"></script>
</body>
</html>
