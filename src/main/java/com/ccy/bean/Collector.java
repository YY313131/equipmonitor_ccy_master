package com.ccy.bean;

import java.util.List;

/**
 * 采集器
 * 
 * @author Wenl
 */
public class Collector {

	private int id;

	private int deviceId;

	private String collectorNo;

	private String collectorState;

	private List<CollectParameter> collectParameters;

	/**
	 * 获取主键id
	 * 
	 * @return 主键id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置主键id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取采集器所在设备id
	 * 
	 * @return
	 */
	public int getDeviceId() {
		return deviceId;
	}

	/**
	 * 设置采集器所在设备id
	 * 
	 * @param deviceId
	 */
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * 获取采集器编号，与底层采集模块对应
	 * 
	 * @return 采集器编号
	 */
	public String getCollectorNo() {
		return collectorNo;
	}

	/**
	 * 设置采集器编号，与底层采集模块对应
	 * 
	 * @param collectorNo
	 *            采集器编号
	 */
	public void setCollectorNo(String collectorNo) {
		this.collectorNo = collectorNo;
	}

	/**
	 * 获取采集器状态
	 * 
	 * @return 采集器状态
	 */
	public String getCollectorState() {
		return collectorState;
	}

	/**
	 * 设置采集器状态
	 * 
	 * @param collectorState
	 *            采集器状态
	 */
	public void setCollectorState(String collectorState) {
		this.collectorState = collectorState;
	}

	/**
	 * 获取关联的采集参数集合
	 * 
	 * @return
	 */
	public List<CollectParameter> getCollectParameters() {
		return collectParameters;
	}

	/**
	 * 设置关联的采集参数集合
	 * 
	 * @param collectParameters
	 */
	public void setCollectParameters(List<CollectParameter> collectParameters) {
		this.collectParameters = collectParameters;
	}

	@Override
	public String toString() {
		return "Collector [id=" + id + ", deviceId=" + deviceId
				+ ", collectorNo=" + collectorNo + ", collectorState="
				+ collectorState + "]";
	}

}
