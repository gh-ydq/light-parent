package com.light.web.controller.light;

import com.light.web.constant.LightCmdReqEnum;
import com.light.web.controller.AbstractController;
import com.light.web.dto.req.light.down.LightInfoCmdReqDto;
import com.qdigo.iotsdk.LightDeviceCtl;
import com.qdigo.iotsdk.constant.LightCmdEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lightDownCmd")
public class LightCmdDownController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(LightCmdDownController.class);
    private final static String IP = "127.0.0.1";
    private final static int PORT = 9001;

    @RequestMapping("/cmdInfo")
    @ResponseBody
    public String downLightCmdInfo(LightInfoCmdReqDto lightInfoReqDto){
        logger.info("downLightCmdInfo userCode={},lightCode={},cmd",lightInfoReqDto.getLightCode(),lightInfoReqDto.getUserCode(),lightInfoReqDto.getLightCmd());
        LightDeviceCtl deviceCtl = new LightDeviceCtl();
        try {
            LightCmdReqEnum lightCmdReqEnum = LightCmdReqEnum.getLightCmdReqEnum(lightInfoReqDto.getLightCmd());
            LightCmdEnum lightCmdEnum = getLightCmdEnum(lightCmdReqEnum,lightInfoReqDto.getLightCmd(),lightInfoReqDto.getLightCode());
            deviceCtl.lightCmd(Long.valueOf(lightInfoReqDto.getLightCode()), lightCmdEnum,IP,PORT);
            return "success";
        }catch (Exception e){
            logger.error("light down cmd error,imei:"+lightInfoReqDto.getLightCode(),e);
            return "false";
        }
    }

    private LightCmdEnum getLightCmdEnum(LightCmdReqEnum lightCmdReqEnum,String cmd,String lightCode ){
        LightCmdEnum lightCmdEnum = lightCmdReqEnum.getLightCmdEnum();
        if(LightCmdReqEnum.DEVICE_CHECK.getCmd().equals(cmd)){
            lightCmdEnum.setParam(lightCode);
        }
        if(LightCmdReqEnum.UPDATE_INSIDE_IMEI_CMD.getCmd().equals(cmd)){
            lightCmdEnum.setParam(lightCode);
        }
        return lightCmdEnum;
    }
}
