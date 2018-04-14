var ShowList = {
	grid_table:$("#grid-table"),
	grid_page:$("#grid-page"),
	page_str:"#grid-page",
	stringOrgSelect:"",
	showResult:function (){
		
		var sex = null;
		if($("#sex > input").val()){
			sex = $("#sex > input").val();
		}
		var isValid = null;
		if($("#isValid > input").val()){
			isValid = $("#isValid > input").val();
		}
		//获取多选下拉框选中的html值
		// var orgIds = multi_select.getValues();
		jQuery(ShowList.grid_table).jqGrid('setGridParam',{ 
			datatype:'json', 
			mtype:"POST",
//			ajaxGridOptions:{contentType:'application/json; charset=utf-8'},//设置请求头
			postData:{
				isValid:isValid,
				sex:sex,
				// orgIds:orgIds,
				userName:$("#userName").val(),
				account:$("#account").val(),
				mobile:$("#phone").val(),
			}
			
		}).trigger("reloadGrid");
	}
}

ShowList.grid_table.jqGrid({
	url:"",
	datatype:"json",
	mtype:"POST",
	colNames:['用户姓名','账号','性别','手机','是否可用','组织','工号','<i class="fa fa-flag" ></i>&nbsp;&nbsp;操作菜单：','分派角色','指派群组','指派职位'],
	colModel:[
		{name:'username',index:'username',width:50,editable:true,edittype:'custom',
			editoptions:{
				custom_element: createInputElement, custom_value:createInpuElementValue
			}
		},
		{name:'account',index:'account',width:40},
		{name:'gender',index:'gender',width:30,editable:true,edittype:'custom',
			editoptions:{
				custom_element: mCreateSelectElement, custom_value:createInpuElementValue
			},
			formatter: function (value) { 
				return ftGender(value);
			}
		},
		{name:'mobile',index:'mobile',width:50,editable:true,edittype:'custom',
			editoptions:{
				custom_element: createInputElement, custom_value:createInpuElementValue
			}
		},
		{name:'isvalid',index:'isvalid',width:30,editable:true,edittype:'custom',
			editoptions:{
				custom_element: mCreateSelectElement, custom_value:createInpuElementValue
			},
			formatter: function (value) { 
				return ftIsValid(value);
			}
		},
		{name:'orgid',index:'orgid',width:60,editable:true,edittype:'custom',
			editoptions:{
				custom_element: createInputElement, custom_value:createInpuElementValue
			},
			formatter: function (value) { 
				return multi_select.getNameByValue(value);
			}
		},
		{name:'workcode',index:'workcode',width:40},
		{name:'button',index:'',width:60,
			formatter: function (value) { 
				return ftButton(value);
			}
		},
		{name:'editRoleButton',index:'',width:1,hidden:true,editable:true,edittype:'custom',
			editrules:{edithidden:true},
			editoptions:{
				custom_element: mCreateButtonElement
			}
		},
		{name:'editGroupButton',index:'',width:1,hidden:true,editable:true,edittype:'custom',
			editrules:{edithidden:true},
			editoptions:{
				custom_element: mCreateButtonElement
			}
		},
		{name:'editPositionButton',index:'',width:1,hidden:true,editable:true,edittype:'custom',
			editrules:{edithidden:true},
			editoptions:{
				custom_element: mCreateButtonElement
			}
		}
	], 		
	loadComplete : function(){
	    initButtonClick();
	},
	height:document.documentElement.clientHeight / 2,//屏幕高度2分之一
	rowNum:10,
	rowList:[10,20,50],
	pager:ShowList.page_str,
	loadonce: true,
	altRows: true,
	viewrecords : true,
	multiselect: true,
	multiboxonly:true,//单选
	editurl:"",
	beforeSelectRow:function(rowid){//单选
		var id = ShowList.grid_table.jqGrid('getGridParam','selrow');
		ShowList.grid_table.jqGrid('resetSelection');  
		if(id && rowid == id){
			return(false);//原本是选中，则取消选中
		}
	    return(true); 
	},
	caption: "用户管理",
	gridComplete:function(){
		ShowList.grid_table.parents(".ui-jqgrid-bdiv").css("overflow-x","hidden");
	}
});

ShowList.grid_table.jqGrid('navGrid',ShowList.page_str,
{ 	//navbar options
	edit: true,
	editicon : 'ace-icon fa fa-pencil blue',
	search: false,
	searchicon : 'ace-icon fa fa-search orange',
	refresh: false,
	refreshicon : 'ace-icon fa fa-refresh green',
	add: false,
	addicon : 'ace-icon fa fa-plus-circle purple',
	del: false,
	delicon : 'ace-icon fa fa-trash-o red',
	view: false,
	viewicon : 'ace-icon fa fa-search-plus grey',
},
/*编辑联系人*/
{ 
	top : 10,  //位置
	left: 200, //位置
	height:440, //大小
	width:750, //大小
	closeOnEscape:true,  
	closeAfterEdit: true, //编辑成功后关闭此窗口
	afterSubmit:function (response,postdata){
	    var json=response.responseText; 
	    if(json == "ok"){
		bootboxDialog("修改成功！","提示","确定");
	    }else{
		bootboxDialog("修改失败！","提示","确定");
	    }
	    return [true, "", ""]; 
	}
});

/**
 * 创建按钮
 * @param value
 * @param options
 */
function mCreateButtonElement(value, options){
	var dom = "";
	if(options.id == "editRoleButton"){
		dom = "<a href='#' class='btn btn-light' id='"+options.id+"' style='height:34px;'><i class='fa fa-user'></i>&nbsp;&nbsp;&nbsp;&nbsp;分派角色</a>";
	} 
	if(options.id == "editGroupButton"){
		dom = "<a href='#' class='btn btn-light' id='"+options.id+"' style='height:34px;'><i class='fa fa-group'></i>&nbsp;&nbsp;&nbsp;指派群组</a>";
	}
	if(options.id == "editPositionButton"){
		dom = "<a href='#' class='btn btn-light' id='"+options.id+"' style='height:34px;'><i class='fa fa-graduation-cap'></i>&nbsp;&nbsp;指派职位</a>";
	}
	return dom;
}

/**
 * 创建input输入框
 * @param value
 * @param options
 * @returns {element[input]}
 */
function createInputElement(value, options) {
	var element = document.createElement("input");
	element.setAttribute("id",options.id);
	element.type="text";
	element.value=value;
	return element;
}

/**
 * 创建一个Select
 */
function mCreateSelectElement(value, options) {
	if(options.id == "isvalid"){
		var element = document.createElement("select");
		element.options.add(new Option("有效","yes"));
		element.options.add(new Option("无效","no"));
		if(value.indexOf("有效") != -1){
			$(element).val("yes");
		} else if(value.indexOf("无效") != -1){
			$(element).val("no");
		}
		return element;
	} else if(options.id == "gender"){
		var element = document.createElement("select");
		element.options.add(new Option("男","F"));
		element.options.add(new Option("女","M"));
		if(value.indexOf("男") != -1){
			$(element).val("F");
		} else if(value.indexOf("女") != -1){
			$(element).val("M");
		}
		return element;
	} else {
		var element = document.createElement("select");
		element.options.add(new Option("有","yes"));
		element.options.add(new Option("无","no"));
		return element;
	}
}

/**
 * 设置input输入框值
 * @param element
 * @returns{element[input.value]}
 */
function createInpuElementValue(element) {
	return $(element).val();
}

//给表格操作栏按钮绑定事件
function initButtonClick(){
	$(".editUserButton").click(function(){
		//刷新之前选中行，避免多选
		ShowList.grid_table.jqGrid('resetSelection');  
		//根据行号设置选中行
		ShowList.grid_table.setSelection($(this).parent().parent().attr("id"));
		//弹出jqGrid修改窗口
		$("#edit_grid-table").trigger("click");
		$(".navButton").remove();//删除修改窗口无用按钮
		$("#sData").children("span").attr("class","fa fa-check");//修改图标样式
		$("#cData").children("span").attr("class","fa fa-close");//修改图标样式
		$("#sData").click(function(){
			//删除修改窗口的组织下拉框
			$(".multi-select").nextSbiling().remove();
			$(".multi-select").remove();
			//将组织下拉框返回原来位置
			//$("#label_orgSelect").append($(ShowList.stringOrgSelect));
			multi_select.selectNames = ShowList.stringOrgSelect;
			multi_select.refresh();
		});
		$("#cData").click(function(){
			//删除修改窗口的组织下拉框
			$(".multi-select").nextSbiling().remove();
			$(".multi-select").remove();
			//将组织下拉框返回原来位置
			//$("#label_orgSelect").append($(ShowList.stringOrgSelect));
			multi_select.selectNames = ShowList.stringOrgSelect;
			multi_select.refresh();
		});
		return false;//阻止事件冒泡
	});
}




//给表格操作栏增加按钮
function ftButton(value){
	var editUserButton = "<a href='#' class='btn btn-light editUserButton' style='height:30px;'><i class='fa fa-edit'></i>&nbsp;&nbsp;修改</a>";
	editUserButton += "<a href='#' class='btn btn-light' id='syncButton' style='height:30px;margin-left:3px;'><i class='fa fa-retweet' aria-hidden='true'></i>&nbsp;&nbsp;同步</a>";
	return editUserButton;
}

//格式化性别
function ftGender(value){
	if(value == "F"){
		return "<i class='fa fa-male' aria-hidden='true'></i>&nbsp;&nbsp;男";
	} else {
		return "<i class='fa fa-female' aria-hidden='true'></i>&nbsp;&nbsp;女";
	}
}
//格式化是否有效
function ftIsValid(value){
	if(value == "yes"){
		return "<i class='fa fa-check' aria-hidden='true'></i>&nbsp;&nbsp;有效";
	} else {
		return "<i class='fa fa-close' aria-hidden='true'></i>&nbsp;&nbsp;无效";
	}
}

//查询
$("#search_user").click(function(){
	//加载tab数据
	ShowList.showResult();
	return false;
});

//清空表单
$("#remove_from").click(function(){
	multi_select.refreshSelected();
	$("#isValid").html("<i class='fa fa-gear' aria-hidden='true'></i>&nbsp;&nbsp;是否可用");
	$("#sex").html("<i class='fa fa-venus-mars' aria-hidden='true'></i>&nbsp;&nbsp;性别");
	$("#account").val("");
	$("#userName").val("");
	$("#phone").val("");
	return false;//阻止事件冒泡
});




function updatePagerIcons() {
	var replacement = 
	{
		'ui-icon-seek-first' : 'ace-icon fa fa-angle-double-left bigger-140',
		'ui-icon-seek-prev' : 'ace-icon fa fa-angle-left bigger-140',
		'ui-icon-seek-next' : 'ace-icon fa fa-angle-right bigger-140',
		'ui-icon-seek-end' : 'ace-icon fa fa-angle-double-right bigger-140'
	};
	$('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function(){
		var icon = $(this);
		var $class = $.trim(icon.attr('class').replace('ui-icon', ''));
		if($class in replacement) {
			icon.attr('class', 'ui-icon '+replacement[$class]);
		}
	});
}