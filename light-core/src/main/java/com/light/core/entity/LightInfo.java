package com.light.core.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="light_info")
public class LightInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="user_code")
    private String userCode;
    @Column(name="light_code")
    private String lightCode;
    @Column(name="battery_voltage")
    private Integer batteryVoltage;
    @Column(name="active_time")
    private Date activeTime;

    @Column(name="used_electric_charge")
    private Double usedElectricCharge;
    @Column(name="active_light_num")
    private Integer activeLightNum;
    @Column(name="used_time")
    private Integer usedTime;
    @Column(name="exception_status")
    private Integer exceptionStatus;
    @Column(name="create_time")
    private Date createTime;
    @Column(name="update_time")
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
