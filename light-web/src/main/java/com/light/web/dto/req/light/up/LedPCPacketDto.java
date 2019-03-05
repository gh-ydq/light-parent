package com.light.web.dto.req.light.up;


/**
 * PC ����Ӧ�Ĳ���
 * @author yudengqiu
 *
 */
public class LedPCPacketDto extends DatagramPacketBasicDto {

	private static final long serialVersionUID = -8597161566517930453L;
	//字节数据长度
	private int length;
	private byte seq;
	private byte cmd;
	private String busiType;
	private String param;
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public byte getSeq() {
		return seq;
	}
	public void setSeq(byte seq) {
		this.seq = seq;
	}
	public byte getCmd() {
		return cmd;
	}
	public void setCmd(byte cmd) {
		this.cmd = cmd;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	@Override
	public String toString() {
		return "LedPCPacketDto [length=" + length + ", seq=" + seq + ", cmd=" + cmd+ ", busiType=" + busiType + ", param=" + param
				+ ", getHeader0()=" + getHeader0() + ", getHeader1()=" + getHeader1() + ", getImei()=" + getImei()
				+ "]";
	}
	
	
	
}
