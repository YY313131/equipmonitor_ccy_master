package com.ccy.bean;

import java.util.List;

/**
 * 子系统
 * 
 * @author Wenl
 */
public class Subsystem {

	private int id;

	private int deviceId;

	private String subsystemNo;

	private String subsystemName;

	private List<Parameter> parameters;

	/**
	 * 获取子系统id
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置子系统id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取子系统所属的设备id
	 * 
	 * @return
	 */
	public int getDeviceId() {
		return deviceId;
	}

	/**
	 * 设置子系统所属的设备的id
	 * 
	 * @param deviceId
	 */
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * 获取子系统编号
	 * 
	 * @return
	 */
	public String getSubsystemNo() {
		return subsystemNo;
	}

	/**
	 * 设置子系统编号
	 * 
	 * @param subsystemNo
	 */
	public void setSubsystemNo(String subsystemNo) {
		this.subsystemNo = subsystemNo;
	}

	/**
	 * 获取子系统名称
	 * 
	 * @return
	 */
	public String getSubsystemName() {
		return subsystemName;
	}

	/**
	 * 设置子系统名称
	 * 
	 * @param subsystemName
	 */
	public void setSubsystemName(String subsystemName) {
		this.subsystemName = subsystemName;
	}

	/**
	 * 获取子系统所有的采集参数
	 * 
	 * @return
	 */
	public List<Parameter> getParameters() {
		return parameters;
	}

	@Override
	public String toString() {
		return "Subsystem [id=" + id + ", deviceId=" + deviceId
				+ ", subsystemNo=" + subsystemNo + ", subsystemName="
				+ subsystemName + ", parameters=" + parameters + "]";
	}

}
