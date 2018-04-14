package com.light.web.controller;

import com.light.core.entity.QUser;
import com.light.core.entity.User;
import com.light.core.impl.UserServiceImpl;
import com.light.web.util.JqGridPage;
import com.light.web.util.SpringWebUtil;
import com.querydsl.core.types.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/led")
public class LedController extends AbstractController{
    private Logger logger = LoggerFactory.getLogger(LedController.class);

    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/info")
    @ResponseBody
    public List<User> ledInfo(HttpServletRequest request){
        int page = Integer.parseInt(SpringWebUtil.getRequest().getParameter("page") != null ? SpringWebUtil.getRequest().getParameter("page") : "0");
        int rows = Integer.parseInt(SpringWebUtil.getRequest().getParameter("rows") != null ? SpringWebUtil.getRequest().getParameter("rows") : "0");
        logger.info("分页查询 page={},rows={}",page,rows);
        Predicate predicate = buildPredicate("zhangsan");
        Page<User> pages = userService.findAllByCretiaPage(page-1,rows,predicate);
//        List<User> destUsers = getUser(users);
        JqGridPage jqGridPage = new JqGridPage();
//        PageInfo<User> pages = new PageInfo<User>(destUsers);
        jqGridPage.setPage(pages.getNumber()+1);
        jqGridPage.setTotal(pages.getTotalPages());
        jqGridPage.setRecords((int)pages.getTotalElements());
        jqGridPage.setRows(pages.getContent());
        SpringWebUtil.getResponse().setHeader("Tansfer-Encoding","chunked");
        this.renderJson(jqGridPage);
        try {
            SpringWebUtil.getResponse().getWriter().close();
        } catch (IOException e) {
            logger.error("ledInfo error",e);
        }
        return null;
    }
    private Predicate buildPredicate(String name){
        Predicate predicate = QUser.user.name.eq(name);

        return predicate;
    }

    private List<User> getUser(Page<User> orignUsers){
        List<User> users = new ArrayList<User>();
        Iterator<User> userIterable = orignUsers.iterator();
        while(userIterable.hasNext()){
            User user = userIterable.next();
            logger.info("user name={},id={}",user.getName(),user.getId());
            users.add(user);
        }
        return users;
    }
}
