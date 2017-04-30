package com.ccy.bean;

/**
 * 采集器参数关系
 * 
 * @author Wenl
 */
public class CollectParameter {

	private int deviceId;

	private int subsystemId;

	private int collectorId;

	private int parameterId;

	private int parameterIndex;

	/**
	 * 获取设备id
	 * 
	 * @return
	 */
	public int getDeviceId() {
		return deviceId;
	}

	/**
	 * 设置设备id
	 * 
	 * @param deviceId
	 */
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	/**
	 * 获取子系统id
	 * 
	 * @return
	 */
	public int getSubsystemId() {
		return subsystemId;
	}

	/**
	 * 设置子系统id
	 * 
	 * @param subsystemId
	 */
	public void setSubsystemId(int subsystemId) {
		this.subsystemId = subsystemId;
	}

	/**
	 * 获取采集器id
	 * 
	 * @return
	 */
	public int getCollectorId() {
		return collectorId;
	}

	/**
	 * 设置采集器id
	 * 
	 * @param collectorId
	 */
	public void setCollectorId(int collectorId) {
		this.collectorId = collectorId;
	}

	/**
	 * 获取参数在采集器传输的数据中的索引
	 * 
	 * @return 索引
	 */
	public int getParameterIndex() {
		return parameterIndex;
	}

	/**
	 * 设置参数在采集器传输的数据中的索引
	 * 
	 * @param parameterIndex
	 *            索引
	 */
	public void setParameterIndex(int parameterIndex) {
		this.parameterIndex = parameterIndex;
	}

	/**
	 * 获取采集参数id
	 * 
	 * @return
	 */
	public int getParameterId() {
		return parameterId;
	}

	/**
	 * 设置采集参数id
	 * 
	 * @param parameterId
	 */
	public void setParameterId(int parameterId) {
		this.parameterId = parameterId;
	}

	@Override
	public String toString() {
		return "CollectParameter [deviceId=" + deviceId + ", subsystemId="
				+ subsystemId + ", collectorId=" + collectorId
				+ ", parameterId=" + parameterId + ", parameterIndex="
				+ parameterIndex + "]";
	}

}
