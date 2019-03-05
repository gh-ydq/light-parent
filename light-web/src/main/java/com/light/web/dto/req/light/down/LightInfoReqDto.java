package com.light.web.dto.req.light.down;

import java.util.Date;

public class LightInfoReqDto {
    private String userCode;
    private String lightCode;
    private Integer batteryVoltage;
    private Date activeTime;
    private Double usedElectricCharge;
    private Integer activeLightNum;
    private Integer usedTime;
    private Integer exceptionStatus;
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

    public Integer getBatteryVoltage() {
        return batteryVoltage;
    }

    public void setBatteryVoltage(Integer batteryVoltage) {
        this.batteryVoltage = batteryVoltage;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Double getUsedElectricCharge() {
        return usedElectricCharge;
    }

    public void setUsedElectricCharge(Double usedElectricCharge) {
        this.usedElectricCharge = usedElectricCharge;
    }

    public Integer getActiveLightNum() {
        return activeLightNum;
    }

    public void setActiveLightNum(Integer activeLightNum) {
        this.activeLightNum = activeLightNum;
    }

    public Integer getUsedTime() {
        return usedTime;
    }

    public void setUsedTime(Integer usedTime) {
        this.usedTime = usedTime;
    }

    public Integer getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(Integer exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public String getLightCmd() {
        return lightCmd;
    }

    public void setLightCmd(String lightCmd) {
        this.lightCmd = lightCmd;
    }
}
