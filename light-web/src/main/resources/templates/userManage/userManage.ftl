<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" href="/assets/css/ui.jqgrid.css" />
		<link rel="stylesheet" href="/assets/css/jquery-ui.css" />
		<link rel="stylesheet" href="/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
		<link rel="stylesheet" href="/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/assets/css/bootstrap-select.css" />
		<link rel="stylesheet" href="/assets/css/bootstrap-select.min.css" />
		<link rel="stylesheet" href="/css/font-awesome.css"/>
		<link rel="stylesheet" href="/css/glyphicons.css" />
		
	</head>
	<style>  
        body{  
            background: #FFFFFF;  
        }  
        #l_div{
        	background-color:#F2F2F2;
        }
        .title{
        	background-color:#e7e7e7!important;
        }
        ul,li{
        	list-style:none;
        }
        
    </style> 

<body>
	<div class="col-xs-12 col-sm-12 col-md-12 title" style="height:50px;margin-top:10px">
			<span class="title" style="height:40px;margin-top:5px">
				<i class="fa fa-binoculars" ></i>&nbsp;&nbsp;查询条件：
			</span>

		    <#--<label class="label-multi-select"></label>-->
			<input type="text" id="userCode" placeholder="用户编号" style="height:34px;width:120px;"/>
			<input type="text" id="lightCode" placeholder="设备号" style="height:34px;width:120px;"/>
			<input type="text" id="exceptionStatus" placeholder="异常状态" style="height:34px;width:120px;"/>
			<a href="#" class="btn btn-light" id="remove_from" style="height:34px;">
				<i class="fa fa-repeat" aria-hidden="true"></i>&nbsp;&nbsp;清空
			</a>
			<a href="#" class="btn btn-light" id="search_user" style="height:40px;margin-left:3px;margin-top:7px">
				<i class="fa fa-search" aria-hidden="true"></i>&nbsp;&nbsp;搜索
			</a>
	</div>
	<div class="col-xs-12 col-sm-12 col-md-12" id="table" style="margin-top:10px">
		<table id="grid-table" style="border-collapse: collapse"></table>
		<div id="grid-page"  style="height:50px;"></div>
	</div>
<script src="/jquery/jquery-1.8.2.min.js"></script>
<script src="/assets/js/jqGrid/jquery.jqGrid.src.js"></script>
<script src="/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<script src="/assets/js/ace.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/bootstrap-select.js"></script>
<script src="/assets/js/bootstrap-select.min.js"></script>
<script src="/assets/js/bootstrap-treeview.js"></script>
<script src="/assets/js/bootbox.js"></script>
<script src="/assets/js/bootbox.min.js"></script>
<#--<script src="/js/plug/btn-select.js"></script>-->
<script src="/js/userManage/userManage.js"></script>
<script type="text/javascript">
	$(function(){
		// multi_select.loadingData("../user/getOrgTree");
		//加载tab数据
		ShowList.showResult();
		//加载分页操作按钮样式
		updatePagerIcons();
		//隐藏分页栏左侧按钮
		$("#grid-page_left").hide();
		
		//表格自适应布局
		$(window).on('resize.jqGrid', function () {
			$(ShowList.grid_table).jqGrid('setGridWidth', $("#table").width() );
		});
		var parent_column = $(ShowList.grid_table).closest('[class*="col-"]');
		$(document).on('settings.ace.jqGrid' , function(ev, event_name, collapsed) {
			if( event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed' ) {
				setTimeout(function() {
					$(ShowList.grid_table).jqGrid( 'setGridWidth', parent_column.width() );
				}, 0);
			}
		});
		$(window).triggerHandler('resize.jqGrid');//trigger window resize to make the grid get the correct size
	});
	
</script>
</body>
</html>
