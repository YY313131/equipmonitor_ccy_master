package com.ccy.bean;

/**
 * 参数
 * 
 * @author Wenl
 */
public class Parameter {

	private int id;

	private int companyId;

	private String sensorNo;

	private String sensorName;

	private String parameterNo;

	private String parameterName;

	private Double upper;

	private Double lower;

	private String suffix;

	/**
	 * 获取采集参数的主键id
	 * 
	 * @return 主键id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置采集参数的主键id
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取所在公司id
	 * 
	 * @return 公司id
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
	 * 获取传感器编号
	 * 
	 * @return 传感器编号
	 */
	public String getSensorNo() {
		return sensorNo;
	}

	/**
	 * 设置传感器编号
	 * 
	 * @param sensorNo
	 *            传感器编号
	 */
	public void setSensorNo(String sensorNo) {
		this.sensorNo = sensorNo;
	}

	/**
	 * 获取传感器名称
	 * 
	 * @return 传感器名称
	 */
	public String getSensorName() {
		return sensorName;
	}

	/**
	 * 设置传感器名称
	 * 
	 * @param sensorName
	 *            传感器名称
	 */
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}

	/**
	 * 获取参数编号，与底层采集器传输的参数编号一致
	 * 
	 * @return 参数编号
	 */
	public String getParameterNo() {
		return parameterNo;
	}

	/**
	 * 设置参数编号
	 * 
	 * @param parameterNo
	 *            参数编号
	 */
	public void setParameterNo(String parameterNo) {
		this.parameterNo = parameterNo;
	}

	/**
	 * 获取参数名称
	 * 
	 * @return 参数名称
	 */
	public String getParameterName() {
		return parameterName;
	}

	/**
	 * 设置参数名称
	 * 
	 * @param parameterName
	 *            参数名称
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	/**
	 * 获取参数上限值
	 * 
	 * @return 参数上限值
	 */
	public Double getUpper() {
		return upper;
	}

	/**
	 * 设置参数上限值
	 * 
	 * @param upper
	 *            参数上限值，可以为null
	 */
	public void setUpper(Double upper) {
		this.upper = upper;
	}

	/**
	 * 获取参数下限值
	 * 
	 * @return 参数下限值
	 */
	public Double getLower() {
		return lower;
	}

	/**
	 * 设置参数下限值
	 * 
	 * @param lower
	 *            参数下限值，可以为null
	 */
	public void setLower(Double lower) {
		this.lower = lower;
	}

	/**
	 * 获取参数单位
	 * 
	 * @return 参数单位
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * 设置参数单位
	 * 
	 * @param suffix
	 *            设置参数单位
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public String toString() {
		return "Parameter [id=" + id + ", companyId=" + companyId
				+ ", sensorNo=" + sensorNo + ", sensorName=" + sensorName
				+ ", parameterNo=" + parameterNo + ", parameterName="
				+ parameterName + ", upper=" + upper + ", lower=" + lower
				+ ", suffix=" + suffix + "]";
	}

}
