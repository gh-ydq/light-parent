package com.light.web.dto.req.light.down;

public class LightInfoCmdReqDto {
    private String userCode;
    private String lightCode;
    private String lightCmd;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getLightCode() {
        return lightCode;
    }

    public void setLightCode(String lightCode) {
        this.lightCode = lightCode;
    }

    public String getLightCmd() {
        return lightCmd;
    }

    public void setLightCmd(String lightCmd) {
        this.lightCmd = lightCmd;
    }
}
