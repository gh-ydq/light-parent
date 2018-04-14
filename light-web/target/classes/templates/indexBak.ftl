<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>通善auth</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/assets/css/ace-rtl.min.css" />
		<link rel="stylesheet" href="/assets/css/ace-skins.min.css" />
		<link rel="stylesheet" href="/css/boostrap-tab.css" />
		<script src="/assets/js/ace-extra.min.js"></script>
	</head>

<body>
<div class="navbar navbar-default" id="navbar">
	<script type="text/javascript">
		try{ace.settings.check('navbar' , 'fixed')}catch(e){}
	</script>

	<div class="navbar-container" id="navbar-container">
		<div class="navbar-header pull-left">
			<a href="#" class="navbar-brand">
				<small>
					<i class="icon-leaf"></i>
					通善auth系统
				</small>
			</a>
		</div>

		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="green">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<i class="icon-envelope icon-animated-vertical"></i>
						<span class="badge badge-success">5</span>
					</a>

					<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
						<li class="dropdown-header">
							<i class="icon-envelope-alt"></i>
							5条消息
						</li>

						<li>
							<a href="#">
								<img src="/assets/avatars/avatar.png" class="msg-photo" alt="Alex's Avatar" />
								<span class="msg-body">
									<span class="msg-title">
										<span class="blue">Alex:</span>
										不知道写啥 ...
									</span>

									<span class="msg-time">
										<i class="icon-time"></i>
										<span>1分钟以前</span>
									</span>
								</span>
							</a>
						</li>

						<li>
							<a href="#">
								<img src="/assets/avatars/avatar3.png" class="msg-photo" alt="Susan's Avatar" />
								<span class="msg-body">
									<span class="msg-title">
										<span class="blue">Susan:</span>
										不知道翻译...
									</span>

									<span class="msg-time">
										<i class="icon-time"></i>
										<span>20分钟以前</span>
									</span>
								</span>
							</a>
						</li>

						<li>
							<a href="#">
								<img src="/assets/avatars/avatar4.png" class="msg-photo" alt="Bob's Avatar" />
								<span class="msg-body">
									<span class="msg-title">
										<span class="blue">Bob:</span>
										到底是不是英文 ...
									</span>

									<span class="msg-time">
										<i class="icon-time"></i>
										<span>下午3:15</span>
									</span>
								</span>
							</a>
						</li>

						<li>
							<a href="inbox.html">
								查看所有消息
								<i class="icon-arrow-right"></i>
							</a>
						</li>
					</ul>
				</li>

				<li class="light-blue">
					<a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<img class="nav-user-photo" src="/assets/avatars/user.jpg" alt="Jason's Photo" />
						<span class="user-info">
							<small>欢迎光临,</small>
							Jason
						</span>

						<i class="icon-caret-down"></i>
					</a>

					<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li>
							<a href="#">
								<i class="icon-cog"></i>
								设置
							</a>
						</li>

						<li>
							<a href="#">
								<i class="icon-user"></i>
								个人资料
							</a>
						</li>

						<li class="divider"></li>

						<li>
							<a href="#">
								<i class="icon-off"></i>
								退出
							</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>

	<div class="main-container-inner">
		<a class="menu-toggler" id="menu-toggler" href="#">
			<span class="menu-text"></span>
		</a>

		<!-- 侧边栏 -->
		<div class="sidebar" id="sidebar">
			<script type="text/javascript">
				try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
			</script>

			<ul class="nav nav-list" id="menu">
				<div class="sidebar-collapse" id="sidebar-collapse">
				  <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>
			</ul>
		</div>

		<!-- tab页 -->
		<div class="main-content">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12" style="padding-left:5px;">
						<ul class="nav nav-tabs" role="tablist" id="tab-menu">
							<li class="active" id="sy-tab" name="li_id" ><a href="#Index" role="tab" data-toggle="tab"><i class='icon-home'></i>首页</a></li>
						</ul>
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="Index">
								<!-- 首页展示内容 -->
								<div class="page-content">
									<div class="row">
										<div class="col-xs-12">
											<div class="alert alert-block alert-success">
												<button type="button" class="close" data-dismiss="alert">
													<i class="icon-remove"></i>
												</button>
												<i class="icon-ok green"></i>
												欢迎使用
												<strong class="green">
													通善auth后台管理系统
													<small>(v2.0.0)</small>
												</strong>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- 右侧齿轮 -->
		<div class="ace-settings-container" id="ace-settings-container">
			<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
				<i class="icon-cog bigger-150"></i>
			</div>

			<div class="ace-settings-box" id="ace-settings-box">
				<div>
					<div class="pull-left">
						<select id="skin-colorpicker" class="hide">
							<option data-skin="default" value="#438EB9">#438EB9</option>
							<option data-skin="skin-1" value="#222A2D">#222A2D</option>
							<option data-skin="skin-2" value="#C6487E">#C6487E</option>
							<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
						</select>
					</div>
					<span>&nbsp; 选择皮肤</span>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
					<label class="lbl" for="ace-settings-navbar"> 固定导航条</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
					<label class="lbl" for="ace-settings-sidebar"> 固定滑动条</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
					<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
					<label class="lbl" for="ace-settings-rtl">切换到左边</label>
				</div>

				<div>
					<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
					<label class="lbl" for="ace-settings-add-container">
						切换窄屏
						<b></b>
					</label>
				</div>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="icon-double-angle-up icon-only bigger-110"></i>
	</a>
</div>
<script type="text/javascript">
	window.jQuery || document.write("<script src='/assets/js/jquery-2.0.3.min.js'>"+"<"+"script>");
</script>
<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
</script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/typeahead-bs2.min.js"></script>
<script src="/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/assets/js/jquery.slimscroll.min.js"></script>
<script src="/assets/js/jquery.easy-pie-chart.min.js"></script>
<script src="/assets/js/jquery.sparkline.min.js"></script>
<script src="/assets/js/flot/jquery.flot.min.js"></script>
<script src="/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="/assets/js/flot/jquery.flot.resize.min.js"></script>
<script src="/assets/js/ace-elements.min.js"></script>
<script src="/assets/js/ace.min.js"></script>

<script src="/js/indexBak.js"></script>
<script src="/js/plug/sidebar-menu.js"></script>
<script src="/js/plug/bootstrap-tab.js"></script>

<script type="text/javascript">
	jQuery(function($) {
		//固定左边菜单的高度
	    $('#sidebar').height($(window).height() - 80);
		initResources();
	})
	
</script>
</body>
</html>

