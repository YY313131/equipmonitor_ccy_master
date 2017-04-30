package com.ccy.bean;

/**
 * 设备
 * 
 * @author Wenl
 */
public class Device {

	private int id;

	private int companyId;

	private String deviceNo;

	private String deviceName;

	/**
	 * 获取设备id
	 * 
	 * @return 设备id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置设备id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取设备所在公司id
	 * 
	 * @return
	 */
	public int getCompanyId() {
		return companyId;
	}

	/**
	 * 设置所在公司id
	 * 
	 * @param companyId
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取设备编号
	 * 
	 * @return 设备编号
	 */
	public String getDeviceNo() {
		return deviceNo;
	}

	/**
	 * 设置设备编号
	 * 
	 * @param deviceNo
	 *            设备编号
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}

	/**
	 * 获取设备名称
	 * 
	 * @return 设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * 设置设备名称
	 * 
	 * @param deviceName
	 *            设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	@Override
	public String toString() {
		return "Device [id=" + id + ", companyId=" + companyId + ", deviceNo="
				+ deviceNo + ", deviceName=" + deviceName + "]";
	}

}