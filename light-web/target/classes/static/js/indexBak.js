var resources = [];

/**
 * 首页左侧菜单加载
 */
function initResources(){
    /*$.ajax({
        url: "/staff/getStaffResourceByStaffId",
        mtype:"POST",
        data: {
            staffId:61
        },
        dataType: "json",
        success: function(data){
            if(data != null){
                for(j = 0; j < data.data.length; j++) {
                    var sidebar = {
                            id:'',
                            text:'',
                            icon:'',
                            url: '/user/userManage',
                            menus:[]
                        };
                    sidebar.id = data.data[j].rescode;
                    sidebar.text = data.data[j].resname;
                    initIcon(sidebar);
                    resources.push(sidebar);
                }
                $('#menu').sidebarMenu({data:resources});
            }
        }
    });*/
    for(j = 0; j < 5; j++) {
        var sidebar = {
            id:'',
            text:'',
            icon:'icon-user',
            url: '/user/userManageBak',
            menus:[]
        };
        sidebar.id = 'aaa'+j;
        sidebar.text = 'zhangsan'+j;
        initIcon(sidebar);
        resources.push(sidebar);
    }
    $('#menu').sidebarMenu({data:resources});
}

function initIcon(sidebar){
    if(sidebar.text == "用户管理"){
        sidebar.icon = "icon-user";
    }
    if(sidebar.text == "资源权限配置"){
        sidebar.icon = "icon-apple";
    }
    if(sidebar.text == "资源管理"){
        sidebar.icon = "icon-leaf";
    }
    if(sidebar.text == "组织管理"){
        sidebar.icon = "icon-glass";
    }
    if(sidebar.text == "字典管理"){
        sidebar.icon = "icon-list";
    }
    if(sidebar.text == "职位管理"){
        sidebar.icon = "icon-user";
    }
    if(sidebar.text == "缓存管理"){
        sidebar.icon = "icon-cog";

    }
    if(sidebar.text == "在线用户管理"){
        sidebar.icon = "icon-user";
    }
    if(sidebar.text == "群组管理"){
        sidebar.icon = "icon-user";
    }
}
