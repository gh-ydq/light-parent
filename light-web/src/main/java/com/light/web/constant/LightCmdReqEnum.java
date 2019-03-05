package com.light.web.constant;

import com.qdigo.iotsdk.constant.LightCmdEnum;

public enum LightCmdReqEnum {
    START_ELETIC("startEletic","开灯",LightCmdEnum.LIGHT_START_CMD),
    STOP_ELETIC("stopEletic","停电",LightCmdEnum.LIGHT_STOP_CMD),
    DEVICE_CHECK("deviceCheck","设备检测",LightCmdEnum.IMEI_KEY_TEST_CMD),
    LIGHT_ADJUST("lightAdjust","亮度调节",LightCmdEnum.LIGHT_ADJUST_CMD),
    UPDATE_INSIDE_IMEI_CMD("updateImei","修改设备内置IMEI，防止设备飞号，便于修复",LightCmdEnum.UPDATE_INSIDE_IMEI_CMD),
    UPDATE_INSIDE_PARAM_CMD("updateInsideParam","修改设备内置参数",LightCmdEnum.UPDATE_INSIDE_PARAM_CMD),
    ;

    private String cmd;
    private String dec;
    private LightCmdEnum lightCmdEnum;

    private LightCmdReqEnum(String cmd, String dec,LightCmdEnum lightCmdEnum){
        this.cmd = cmd;
        this.dec = dec;
        this.lightCmdEnum = lightCmdEnum;
    }
    public static LightCmdReqEnum getLightCmdReqEnum(String cmd){
        LightCmdReqEnum[] lightCmdReqEnums = LightCmdReqEnum.values();
        for(LightCmdReqEnum lightCmdReqEnum : lightCmdReqEnums){
            if(lightCmdReqEnum.getCmd().equals(cmd)){
                return lightCmdReqEnum;
            }
        }
        return null;
    }
    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public LightCmdEnum getLightCmdEnum() {
        return lightCmdEnum;
    }

    public void setLightCmdEnum(LightCmdEnum lightCmdEnum) {
        this.lightCmdEnum = lightCmdEnum;
    }
}
