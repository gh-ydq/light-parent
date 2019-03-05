package com.light.web.controller.light;

import com.light.core.entity.LightInfo;
import com.light.core.entity.QLightInfo;
import com.light.core.impl.LightInfoServiceImpl;
import com.light.web.controller.AbstractController;
import com.light.web.dto.req.light.down.LightInfoReqDto;
import com.light.web.util.JqGridPage;
import com.light.web.util.SpringWebUtil;
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

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/light")
public class LightController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(LightController.class);

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


}
