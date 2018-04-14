package com.light.web.controller;

import com.light.core.entity.LightInfo;
import com.light.core.entity.QLightInfo;
import com.light.core.entity.QUser;
import com.light.core.entity.User;
import com.light.core.impl.LightInfoServiceImpl;
import com.light.core.impl.UserServiceImpl;
import com.light.web.util.JqGridPage;
import com.light.web.util.SpringWebUtil;
import com.qdigo.iotsdk.DeviceCtl;
import com.qdigo.iotsdk.LightDeviceCtl;
import com.qdigo.iotsdk.constant.LightCmdEnum;
import com.querydsl.core.types.Predicate;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping(value = "/light")
public class LightController extends AbstractController{
    private Logger logger = LoggerFactory.getLogger(LightController.class);
    private final static String IP = "127.0.0.1";
    private final static int PORT = 9001;
    @Autowired
    private LightInfoServiceImpl lightInfoService;
    @RequestMapping("/info")
    @ResponseBody
    public List<LightInfo> querylightInfo(){
        int page = Integer.parseInt(SpringWebUtil.getRequest().getParameter("page") != null ? SpringWebUtil.getRequest().getParameter("page") : "0");
        int rows = Integer.parseInt(SpringWebUtil.getRequest().getParameter("rows") != null ? SpringWebUtil.getRequest().getParameter("rows") : "0");
        logger.info("分页查询 page={},rows={},request",page,rows);
        Page<LightInfo> pages = lightInfoService.findAllByCretiaPage(page-1,rows,buildPredicate());
        JqGridPage jqGridPage = new JqGridPage();
        jqGridPage.setPage(pages.getNumber()+1);
        jqGridPage.setTotal(pages.getTotalPages());
        jqGridPage.setRecords((int)pages.getTotalElements());
        jqGridPage.setRows(pages.getContent());
        SpringWebUtil.getResponse().setHeader("Tansfer-Encoding","chunked");
        this.renderJson(jqGridPage);
        try {
            SpringWebUtil.getResponse().getWriter().close();
        } catch (IOException e) {
            logger.error("lightInfo error",e);
        }
        return null;
    }

    @RequestMapping("/updateInfo")
    @ResponseBody
    public String updateLightInfo(LightInfo lightInfo){
        logger.info("更新信息 userCode={},lightCode={},exceptionStatus={}",lightInfo.getLightCode(),lightInfo.getUserCode());
        LightDeviceCtl deviceCtl = new LightDeviceCtl();
        deviceCtl.lightCmd(Long.valueOf(lightInfo.getLightCode()), LightCmdEnum.LIGHT_START_CMD,IP,PORT);
        return "false";
    }
    private Predicate buildPredicate(){
        String lightCode = SpringWebUtil.getRequest().getParameter("lightCode");
        String userCode = SpringWebUtil.getRequest().getParameter("userCode");
        String exceptionStatus = SpringWebUtil.getRequest().getParameter("exceptionStatus");
        logger.info("查询条件 userCode={},lightCode={},exceptionStatus={}",lightCode,userCode,exceptionStatus);
        QLightInfo qLightInfo = QLightInfo.lightInfo;
        Predicate predicate = null;
        if(StringUtils.isNotBlank(lightCode)){
            predicate = qLightInfo.lightCode.eq(lightCode);
        }
        if(StringUtils.isNotBlank(userCode)){
            predicate = qLightInfo.userCode.eq(userCode).and(predicate);
        }
        if(StringUtils.isNotBlank(exceptionStatus)){
            predicate = qLightInfo.exceptionStatus.eq(Integer.valueOf(exceptionStatus)).and(predicate);
        }
        return predicate;
    }

    private List<LightInfo> getLightInfo(Page<LightInfo> orignLightinfos){
        List<LightInfo> lightInfos = new ArrayList<LightInfo>();
        Iterator<LightInfo> lightInfoIterable = orignLightinfos.iterator();
        while(lightInfoIterable.hasNext()){
            LightInfo lightInfo = lightInfoIterable.next();
            logger.info("lightInfo infoCode={},id={}",lightInfo.getLightCode(),lightInfo.getId());
            lightInfos.add(lightInfo);
        }
        return lightInfos;
    }
}
