package com.light.web.controller.light;

import com.light.core.entity.LightInfo;
import com.light.core.impl.LightInfoServiceImpl;
import com.light.web.controller.AbstractController;
import com.light.web.dto.req.light.up.LedPHPacketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lightUpcmd")
public class LightCmdUpController extends AbstractController {
    private Logger logger = LoggerFactory.getLogger(LightCmdUpController.class);

    @Autowired
    private LightInfoServiceImpl lightInfoService;

    @RequestMapping(value = "/save")
    @ResponseBody
    public void saveLightUpCmd(@RequestBody LedPHPacketDto ledPHPacketDto){
        LightInfo lightInfo = buildLightInfo(ledPHPacketDto);
        lightInfoService.saveLightInfo(lightInfo);
    }

    private LightInfo buildLightInfo(LedPHPacketDto ledPHPacketDto){
        LightInfo lightInfo = new LightInfo();
        lightInfo.setLightCode(ledPHPacketDto.getImei()+"");
        lightInfo.setActiveLightNum((int)ledPHPacketDto.getActiveLightNum());
        lightInfo.setBatteryVoltage((int)ledPHPacketDto.getBatteryVoltage());
        lightInfo.setUsedTime(ledPHPacketDto.getLightUsedHour());
        lightInfo.setExceptionStatus((int)ledPHPacketDto.getDeviceSatus());
        return lightInfo;
    }
}
