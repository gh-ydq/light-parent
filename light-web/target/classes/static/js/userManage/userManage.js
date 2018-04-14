var ShowList = {
	grid_table:$("#grid-table"),
	grid_page:$("#grid-page"),
	page_str:"#grid-page",
	stringOrgSelect:"",
	showResult:function (){
		
		var sex = null;
		// if($("#sex > input").val()){
		// 	sex = $("#sex > input").val();
		// }
		// var isValid = null;
		// if($("#isValid > input").val()){
		// 	isValid = $("#isValid > input").val();
		// }
		//获取多选下拉框选中的html值
		// var orgIds = multi_select.getValues();
		jQuery(ShowList.grid_table).jqGrid('setGridParam',{ 
			datatype:'json', 
			mtype:"POST",
//			ajaxGridOptions:{contentType:'application/json; charset=utf-8'},//设置请求头
			postData:{
				// orgIds:orgIds,
                userCode:$("#userCode").val(),
                lightCode:$("#lightCode").val(),
                exceptionStatus:$("#exceptionStatus").val(),
			}
			
		}).trigger("reloadGrid");
	}
}

// ShowList.grid_table.jqGrid({
// 	url:"/led/info",
// 	datatype:"json",
// 	mtype:"POST",
// 	colNames:['用户姓名','城市','地址','<i class="fa fa-flag" ></i>&nbsp;&nbsp;操作'],
// 	colModel:[
//         {name:'name',index:'name',width:40},
//         {name:'address',index:'address',width:40},
//         {name:'city',index:'city',width:40},
//
// 		// {name:'name',index:'name',width:50,editable:true,edittype:'custom',
// 		// 	editoptions:{
// 		// 		custom_element: createInputElement, custom_value:createInpuElementValue
// 		// 	}
// 		// },
// 		// {name:'account',index:'account',width:40},
// 		// {name:'gender',index:'gender',width:30,editable:true,edittype:'custom',
// 		// 	editoptions:{
// 		// 		custom_element: mCreateSelectElement, custom_value:createInpuElementValue
// 		// 	},
// 		// 	formatter: function (value) {
// 		// 		return ftGender(value);
// 		// 	}
// 		// },
// 		// {name:'mobile',index:'mobile',width:50,editable:true,edittype:'custom',
// 		// 	editoptions:{
// 		// 		custom_element: createInputElement, custom_value:createInpuElementValue
// 		// 	}
// 		// },
// 		// {name:'isvalid',index:'isvalid',width:30,editable:true,edittype:'custom',
// 		// 	editoptions:{
// 		// 		custom_element: mCreateSelectElement, custom_value:createInpuElementValue
// 		// 	},
// 		// 	formatter: function (value) {
// 		// 		return ftIsValid(value);
// 		// 	}
// 		// },
// 		// {name:'orgid',index:'orgid',width:60,editable:true,edittype:'custom',
// 		// 	editoptions:{
// 		// 		custom_element: createInputElement, custom_value:createInpuElementValue
// 		// 	},
// 		// 	formatter: function (value) {
// 		// 		return multi_select.getNameByValue(value);
// 		// 	}
// 		// },
// 		// {name:'workcode',index:'workcode',width:40},
// 		{name:'button',index:'',width:60,
// 			formatter: function (value) {
// 				return ftButton(value);
// 			}
// 		}
// 	],
// 	loadComplete : function(){
// 	    initButtonClick();
// 	},
// 	height:document.documentElement.clientHeight / 2,//屏幕高度2分之一
// 	rowNum:10,
// 	rowList:[10,20,50],
// 	pager:ShowList.page_str,
// 	loadonce: true,
// 	altRows: true,
// 	viewrecords : true,
// 	multiselect: true,
// 	multiboxonly:true,//单选
// 	editurl:"",
// 	beforeSelectRow:function(rowid){//单选
// 		var id = ShowList.grid_table.jqGrid('getGridParam','selrow');
// 		ShowList.grid_table.jqGrid('resetSelection');
// 		if(id && rowid == id){
// 			return(false);//原本是选中，则取消选中
// 		}
// 	    return(true);
// 	},
// 	caption: "用户管理",
// 	gridComplete:function(){
// 		ShowList.grid_table.parents(".ui-jqgrid-bdiv").css("overflow-x","hidden");
// 	}
// }

ShowList.grid_table.jqGrid({
    url:"/light/info",
    datatype:"json",
    mtype:"POST",
    colNames:['用户编码','设备号','电池电压','激活时间','路灯用电量','灯数量显示','使用时间','异常状态','<i class="fa fa-flag" ></i>&nbsp;&nbsp;操作','命令选择'],
    colModel:[
        {name:'userCode',index:'userCode',width:40,editable:true,edittype:'custom',
			editoptions:{
				custom_element: createInputElement, custom_value:createInpuElementValue
			}},
        {name:'lightCode',index:'lightCode',width:40,editable:true,edittype:'custom',
            editoptions:{
                custom_element: createInputElement, custom_value:createInpuElementValue
            }},
        {name:'batteryVoltage',index:'batteryVoltage',width:40},
        {name:'activeTime',index:'activeTime',width:40},
        {name:'usedElectricCharge',index:'usedElectricCharge',width:40},
        {name:'activeLightNum',index:'activeLightNum',width:40},
        {name:'usedTime',index:'usedTime',width:40},
        {name:'exceptionStatus',index:'exceptionStatus',width:40},


        {name:'button',index:'',width:60,

            formatter: function (value) {
                return ftButton(value);
            }
        },
        {name:'editCmdButton',index:'',width:1,hidden:true,editable:true,edittype:'custom',
            editrules:{edithidden:true},
            editoptions:{
                custom_element: mCreateSelectElement, custom_value:createInpuElementValue
            }}

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
    editurl:"/light/updateInfo",
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
	height:340, //大小
	width:750, //大小
	closeOnEscape:true,  
	closeAfterEdit: true, //编辑成功后关闭此窗口
	afterSubmit:function (response,postdata){
	    var json=response.responseText;
	    var data = "测试成功";
	    if(json == "success"){
            bootbox.alert({
                buttons: {
                    ok: {
                        label: '确定',
                        className: 'btn-myStyle'
                    }
                },
                message: data,
                /*callback: function() {
                    alert('关闭了alert');
                },*/
                title: "修改成功",
            });

        }else{
            bootbox.alert({
                buttons: {
                    ok: {
                        label: '确定',
                        className: 'btn-myStyle'
                    }
                },
                message: data,
                /*callback: function() {
                    alert('关闭了alert');
                },*/
                title: "修改失败",
            });

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
	if(options.id == editCmdButton){
        dom = "<a href='#' class='btn btn-light' id='"+options.id+"' style='height:34px;'><i class='fa fa-graduation-cap'></i>&nbsp;&nbsp;操作命令</a>";
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
		element.options.add(new Option("停电","stopEletic"));
		element.options.add(new Option("检测","check"));
		if(value.indexOf("停电") != -1){
			$(element).val("stopEletic");
		} else if(value.indexOf("检测") != -1){
			$(element).val("check");
		}
		return element;
	} else {
		var element = document.createElement("select");
        element.options.add(new Option("停电","stopEletic"));
        element.options.add(new Option("检测","check"));
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
			// $(".multi-select").nextSbiling().remove();
			// $(".multi-select").remove();
			//将组织下拉框返回原来位置
			//$("#label_orgSelect").append($(ShowList.stringOrgSelect));
			// multi_select.selectNames = ShowList.stringOrgSelect;
			// multi_select.refresh();
		});
		$("#cData").click(function(){
			//删除修改窗口的组织下拉框
			// $(".multi-select").nextSbiling().remove();
			// $(".multi-select").remove();
			//将组织下拉框返回原来位置
			//$("#label_orgSelect").append($(ShowList.stringOrgSelect));
			// multi_select.selectNames = ShowList.stringOrgSelect;
			// multi_select.refresh();
		});
		return false;//阻止事件冒泡
	});
}




//给表格操作栏增加按钮
function ftButton(value){
	var editUserButton = "<a href='#' class='btn btn-light editUserButton' style='height:30px;'><i class='fa fa-edit'></i>&nbsp;&nbsp;修改</a>";
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
	// multi_select.refreshSelected();
    $("#userCode").val("");
    $("#lightCode").val("");
    $("#exceptionStatus").val("");
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