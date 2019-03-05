package com.light.web.dto.req.light.up;

import java.io.Serializable;

/**
 * socket��ݰ�ͷ��Ϣ
 * @author yudengqiu
 *
 */
public class DatagramPacketBasicDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7869686439958718471L;
	private char header0;
	private char header1;
	private String busiType;
	// IMEI 号
	private int imei;
	public char getHeader0() {
		return header0;
	}
	public void setHeader0(char header0) {
		this.header0 = header0;
	}
	public char getHeader1() {
		return header1;
	}
	public void setHeader1(char header1) {
		this.header1 = header1;
	}
	public int getImei() {
		return imei;
	}
	public void setImei(int imei) {
		this.imei = imei;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	@Override
	public String toString() {
		return "DatagramPacketBasicDto{" +
				"header0=" + header0 +
				", header1=" + header1 +
				", imei=" + imei +
				", busiType=" + busiType +
				'}';
	}
}
