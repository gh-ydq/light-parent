$("ul.dropdown-menu > li.optionItem").click(function(){
	$(this).parent().prev().children("font").html($(this).children("a").html());
	$(this).parent().parent().attr("class","btn-group");//关闭下拉框
	return false;
});


/**
 * 树形[多选]下拉框，带模糊搜索功能
 */
var multi_select={
	group:null,//组选项暂存对象
	a_optionAll:null,//所有a
	optionAll:null,//所有option
	selectNames:new Array(),//select显示名称
	loadingData:function(url){//加载后台数据
		$.ajax({
	        url: url,
	        type: "GET",
	        async:false,
	        success: function(data) {
	        	if(data.data){
	        		var orgSelect = "<select class='selectpicker multi-select' data-live-search='true' multiple></select>";
	        		var option = "<option value='"+data.data.orgId+"' class='"+data.data.orgLevel+"'>"+data.data.orgName+"</option>";
	        		
	        		$(".label-multi-select").append(orgSelect);
	        		$(".label-multi-select").children("select").append(option);
	        		multi_select.initOrg(data.data.subOrg,$(".label-multi-select").children("select"));
	        		multi_select.refresh();
	        		multi_select.a_optionAll=$("a.select_group");//所有a
	        		multi_select.optionAll=$(".multi-select > option");//所有option
	        	}
	        }
		});
	},
	//递归遍历后台数据
	initOrg:function (subOrg,orgSelect){
		for (var i = 0; i < subOrg.length; i++) {
			var space = "";
			var orgId = subOrg[i].orgId;
			var spaceNum = subOrg[i].spaceNum;
			var optClass = subOrg[i].orgLevel;
			var orgName = subOrg[i].orgName;
			var sub = subOrg[i].subOrg;
			for (var j = 0; j < spaceNum; j++) {
				space += "&nbsp;";
			}
			var option = "<option value='"+orgId+"' class='"+optClass+"'>"+space+orgName+"</option>";
			orgSelect.append(option);
			if(sub.length > 0){
				multi_select.initOrg(sub,orgSelect);
			}
		}
	},
	//根据id设置组织下拉框选中(单选)
	setSelectedByName:function (name){
		var selectOrg = $("a.select_group");
		for (var i = 0; i < selectOrg.length; i++) {
			if($(selectOrg[i]).children("span").html().replace(new RegExp(/(&nbsp;)/g),"") == name){
				$(selectOrg[i]).parent().attr("class","selected");
				$(selectOrg[i]).parent().parent().parent().prev().attr("title",name);
				name += "&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>";
				$(selectOrg[i]).parent().parent().parent().prev().children().html(name);
				return;
			}
		}
	},
	refresh:function (){
		$(".multi-select").selectpicker({
			selectedText:'cat'
		});
		//初始化组织下拉框样式
		setTimeout("multi_select.init_multi_select()",100);
		$(".bootstrap-select").attr("style","margin-top:9px");
		$(".bootstrap-select > button").attr("class","btn selectpicker btn-light");
		$(".bootstrap-select > button > span.pull-left").attr("class","filter-option pull-left");
		$(".bootstrap-select > button > span.pull-left").html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		$(".bootstrap-select > button > span.caret").remove();
	},
	init_multi_select:function (){
		multi_select.selectNames = new Array();
		$("a.select_group").click(function(){
			multi_select.group = $(this);
			multi_select.selectedGroup();
			setTimeout("multi_select.initSelectName()",2);
			return false;
		});
	},
	//递归遍历子节点
	optionSub:function (flag,item){
		if(!item.attr("class")){//没有子节点
			return;//结束递归
		}
		var number1 = parseInt(multi_select.group.attr("class").substring(multi_select.group.attr("class").length - 1,multi_select.group.attr("class").length));
		var number2 = parseInt(item.attr("class").substring(item.attr("class").length - 1,item.attr("class").length));
		if(flag){
			if(number1 < number2 && !item.hasClass(multi_select.group.attr("class"))){
				if(!multi_select.isInArray(multi_select.selectNames,item.children("span").html().replace(new RegExp(/(&nbsp;)/g),""))){
					multi_select.selectNames.push(item.children("span").html().replace(new RegExp(/(&nbsp;)/g),""));
				}
				item.parent().attr("class","selected");
				if(item.parent().next()){
					multi_select.optionSub(flag,item.parent().next().children());//递归
				} else {//没有下个节点
					return;//结束递归
				}
			} else {
				return;//结束递归
			}
		} else {
			if(number1 < number2 && !item.hasClass(multi_select.group.attr("class"))){
				multi_select.deleteArray(multi_select.selectNames,item.children("span").html().replace(new RegExp(/(&nbsp;)/g),""));
				item.parent().attr("class","");
				if(item.parent().next()){
					multi_select.optionSub(flag,item.parent().next().children());//递归
				} else {//没有下个节点
					return;//结束递归
				}
			} else {
				return;//结束递归
			}
		}
	},
	selectedGroup:function (){
		var item = multi_select.group.parent().next().children();
		if(!multi_select.group.parent().hasClass("selected")){
			if(item.attr("class"))multi_select.optionSub(true,item);
			if(!multi_select.isInArray(multi_select.selectNames,multi_select.group.children("span").html().replace(new RegExp(/(&nbsp;)/g),""))){
				multi_select.selectNames.push(multi_select.group.children("span").html().replace(new RegExp(/(&nbsp;)/g),""));
			}
			multi_select.group.parent().attr("class","selected");
		}else{
			if(item.attr("class"))multi_select.optionSub(false,item);
			multi_select.deleteArray(multi_select.selectNames,multi_select.group.children("span").html().replace(new RegExp(/(&nbsp;)/g),""));
			multi_select.group.parent().attr("class","");
		}
		var selectName = "";
		for (var i = 0; i < multi_select.selectNames.length; i++) {
			selectName += multi_select.selectNames[i]
			if(i < multi_select.selectNames.length -1){
				selectName += ",";
			}
		}
		if(multi_select.selectNames.length > 0){
			multi_select.group.parent().parent().parent().prev().attr("title",selectName);
			selectName += "&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>";
			multi_select.group.parent().parent().parent().prev().children().html(selectName);
		} else {
			multi_select.group.parent().parent().parent().prev().attr("title","");
			selectName += "&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>";
			multi_select.group.parent().parent().parent().prev().children().html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		}
	},
	initSelectName:function (){
		if(multi_select.group.parent().parent().parent().prev().children().html().indexOf('Nothing selected') != -1 || multi_select.selectNames.length == 0){
			multi_select.group.parent().parent().parent().prev().children().html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		}
	},
	getValues:function(){
		var values = "";
		var selectOrg = multi_select.a_optionAll.parent();
		for (var i = 0; i < selectOrg.length; i++) {
			if($(selectOrg[i]).hasClass("selected")){
				var name = $(selectOrg[i]).children("a").children("span").html().replace(new RegExp(/(&nbsp;)/g),"");
				var selectAll = multi_select.optionAll;
				for (var j = 0; j < selectAll.length; j++) {
					if($(selectAll[j]).html().replace(new RegExp(/(&nbsp;)/g),"") == name){
						values += $(selectAll[j]).val() + ",";
					}
				}
			}
		}
		return values;
	},
	getNameByValue:function(value){
		var selectAll = multi_select.optionAll;
		for (var j = 0; j < selectAll.length; j++) {
			if($(selectAll[j]).val() == value){
				return $(selectAll[j]).html().replace(new RegExp(/(&nbsp;)/g),"");
			}
		}
	},
	refreshSelected:function(){
		$('.multi-select').selectpicker('render');
		multi_select.selectNames.splice(0,multi_select.selectNames.length);
		$("a.select_group").parent().attr("class","");
		$(".multi-select").selectpicker({
			selectedText:'cat'
		});
		$(".bootstrap-select").attr("style","margin-top:9px");
		$(".bootstrap-select > button").attr("class","btn selectpicker btn-light");
		$(".bootstrap-select > button > span.pull-left").attr("class","filter-option pull-left");
		$(".bootstrap-select > button > span.pull-left").html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		$(".bootstrap-select > button > span.caret").remove();
	},
	deleteArray:function (array,data){
		var number = 0;
		var flag = false;
		for (var i = 0; i < array.length; i++) {
			if(array[i] == data){
				number = i;
				flag = true;
			}
		}
		if(flag){
			array.splice(number,1);
		}
	},
	isInArray:function (arr,value){
	    for(var i = 0; i < arr.length; i++){
	        if(value === arr[i]){
	            return true;
	        }
	    }
	    return false;
	}
};




/**
 * 树形[单选]下拉框，带模糊搜索功能
 */
var single_select={
	group:null,//组选项暂存对象
	selectNames:new Array(),//select显示名称
	loadingData:function(url){//加载后台数据
		$.ajax({
	        url: url,
	        type: "GET",
	        success: function(data) {
	        	if(data.data){
	        		var orgSelect = "<select class='selectpicker multi-select' data-live-search='true' multiple></select>";
	        		var option = "<option value='"+data.data.orgId+"' class='"+data.data.orgLevel+"'>"+data.data.orgName+"</option>";
	        		
	        		$(".label-multi-select").append(orgSelect);
	        		$(".label-multi-select").children("select").append(option);
	        		single_select.initOrg(data.data.subOrg,$(".label-multi-select").children("select"));
	        		single_select.refresh();
	        	}
	        }
		});
	},
	//递归遍历后台数据
	initOrg:function (subOrg,orgSelect){
		for (var i = 0; i < subOrg.length; i++) {
			var space = "";
			var orgId = subOrg[i].orgId;
			var spaceNum = subOrg[i].spaceNum;
			var optClass = subOrg[i].orgLevel;
			var orgName = subOrg[i].orgName;
			var sub = subOrg[i].subOrg;
			for (var j = 0; j < spaceNum; j++) {
				space += "&nbsp;";
			}
			var option = "<option value='"+orgId+"' class='"+optClass+"'>"+space+orgName+"</option>";
			orgSelect.append(option);
			if(sub.length > 0){
				single_select.initOrg(sub,orgSelect);
			}
		}
	},
	//根据id设置组织下拉框选中(单选)
	setSelectedByName:function (name){
		var selectOrg = $("a.select_group");
		for (var i = 0; i < selectOrg.length; i++) {
			if($(selectOrg[i]).children("span").html().replace(new RegExp(/(&nbsp;)/g),"") == name){
				$(selectOrg[i]).parent().attr("class","selected");
				$(selectOrg[i]).parent().parent().parent().prev().attr("title",name);
				name += "&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>";
				$(selectOrg[i]).parent().parent().parent().prev().children().html(name);
				return;
			}
		}
	},
	refresh:function (){
		$(".multi-select").selectpicker({
			selectedText:'cat'
		});
		//初始化组织下拉框样式
		setTimeout("single_select.init_single_select()",100);
		$(".bootstrap-select").attr("style","margin-top:9px");
		$(".bootstrap-select > button").attr("class","btn selectpicker btn-light");
		$(".bootstrap-select > button > span.pull-left").attr("class","filter-option pull-left");
		$(".bootstrap-select > button > span.pull-left").html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		$(".bootstrap-select > button > span.caret").remove();
	},
	init_single_select:function (){
		single_select.selectNames = new Array();
		$("a.select_group").click(function(){
			single_select.single = $(this);
			single_select.selectedGroup();
			setTimeout("single_select.initSelectName()",2);
			return false;
		});
	},
	selectedGroup:function (){
		var item = single_select.single.parent().next().children();
		if(!single_select.single.parent().hasClass("selected")){
			if(item.attr("class"))
			if(!single_select.isInArray(single_select.selectNames,single_select.single.children("span").html().replace(new RegExp(/(&nbsp;)/g),""))){
				single_select.selectNames.push(single_select.single.children("span").html().replace(new RegExp(/(&nbsp;)/g),""));
			}
			single_select.single.parent().attr("class","selected");
		}else{
			if(item.attr("class"))
			single_select.deleteArray(single_select.selectNames,single_select.single.children("span").html().replace(new RegExp(/(&nbsp;)/g),""));
			single_select.single.parent().attr("class","");
		}
		var selectName = "";
		for (var i = 0; i < single_select.selectNames.length; i++) {
			selectName += single_select.selectNames[i]
			if(i < single_select.selectNames.length -1){
				selectName += ",";
			}
		}
		if(single_select.selectNames.length > 0){
			single_select.single.parent().parent().parent().prev().attr("title",selectName);
			selectName += "&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>";
			single_select.single.parent().parent().parent().prev().children().html(selectName);
		} else {
			single_select.single.parent().parent().parent().prev().attr("title","");
			selectName += "&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>";
			single_select.single.parent().parent().parent().prev().children().html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		}
	},
	initSelectName:function (){
		if(single_select.single.parent().parent().parent().prev().children().html().indexOf('Nothing selected') != -1 || single_select.selectNames.length == 0){
			single_select.single.parent().parent().parent().prev().children().html("<i class='fa fa-group'></i>&nbsp;&nbsp;组织&nbsp;&nbsp;<i class='icon-angle-down icon-on-right'></i>");
		}
	},
	deleteArray:function (array,data){
		var number = 0;
		var flag = false;
		for (var i = 0; i < array.length; i++) {
			if(array[i] == data){
				number = i;
				flag = true;
			}
		}
		if(flag){
			array.splice(number,1);
		}
	},
	isInArray:function (arr,value){
	    for(var i = 0; i < arr.length; i++){
	        if(value === arr[i]){
	            return true;
	        }
	    }
	    return false;
	}
};