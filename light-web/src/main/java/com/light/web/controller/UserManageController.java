package com.light.web.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
@EnableAutoConfiguration
public class UserManageController extends AbstractController{
	
//	@Autowired
//	private UserManageService userManageService;

	@RequestMapping("/userManage")
	public String userManage(){
		return "userManage/userManage";
	}

	@RequestMapping("/userManageBak")
	public String userManageBak(){
		return "userManage/userManage-bak";
	}

//	@ResponseBody
//	@RequestMapping("/getOrgTree")
//	public WebJsonResult<OrgSelectDto> getOrgTree(){
//		return userManageService.getOrgTree();
//	}
//
//	@RequestMapping(value="/getUserByFrom")
//	public void getUserByFrom(){
//		UserManageDto userManageDto = new UserManageDto();
//		List<Integer> orgIds = new ArrayList<Integer>();
//		String isValid = SpringWebUtil.getRequest().getParameter("isValid");
//		String sex = SpringWebUtil.getRequest().getParameter("sex");
//		String strOrgIds = SpringWebUtil.getRequest().getParameter("orgIds");
//		String userName = SpringWebUtil.getRequest().getParameter("userName");
//		String account = SpringWebUtil.getRequest().getParameter("account");
//		String mobile = SpringWebUtil.getRequest().getParameter("mobile");
//		String page = SpringWebUtil.getRequest().getParameter("page");
//		String rows = SpringWebUtil.getRequest().getParameter("rows");
//		userManageDto.setIsValid(isValid);
//		userManageDto.setSex(sex);
//		if(StringUtils.isNotEmpty(strOrgIds)){
//			String[] ids = strOrgIds.split(",");
//			for (int i = 0; i < ids.length; i++) {
//				orgIds.add(Integer.valueOf(ids[i]));
//			}
//		}
//
//		userManageDto.setOrgIds(orgIds);
//		userManageDto.setUserName(userName);
//		userManageDto.setAccount(account);
//		userManageDto.setMobile(mobile);
//		userManageDto.setPage(page != null ? Integer.valueOf(page) : 1);
//		userManageDto.setRows(rows != null ? Integer.valueOf(rows) : 10);
//
//		List<CaStaff> list = userManageService.getUserByFrom(userManageDto);
//		JqGridPage jqGridPage = new JqGridPage();
//		PageInfo<CaStaff> pages = new PageInfo<CaStaff>(list);
//		jqGridPage.setPage(pages.getPageNum());
//		jqGridPage.setTotal(pages.getPages());
//		jqGridPage.setRecords((int) pages.getTotal());
//		jqGridPage.setRows(list);
//		this.renderJson(jqGridPage);
//		return;
//	}
	@RequestMapping(value="/getUserByFrom")
	public void getUserByFrom(){
		this.renderJson("");
		return;
	}
	
}
