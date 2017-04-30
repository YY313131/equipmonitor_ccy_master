package com.ccy.bean;

/**
 * 公司
 * 
 * @author Wenl
 */
public class Company {

	private int id;

	private String companyName;

	private String companyAddress;

	private String contactPersonName;

	private String contactPhoneNumber;

	private String contacteEMail;

	/**
	 * 获取主键Id
	 * 
	 * @return id
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
	 * 获取公司名称
	 * 
	 * @return 公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置公司名称
	 * 
	 * @param companyName
	 *            公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * 获取公司地址
	 * 
	 * @return 公司地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * 设置公司地址
	 * 
	 * @param companyAddress
	 *            公司地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * 获取联系人名称
	 * 
	 * @return 联系人名称
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}

	/**
	 * 设置联系人名称
	 * 
	 * @param contactPersonName
	 *            联系人名称
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * 获取联系人电话
	 * 
	 * @return 联系人电话
	 */
	public String getContactPhoneNumber() {
		return contactPhoneNumber;
	}

	/**
	 * 设置联系人电话
	 * 
	 * @param contactPhoneNumber
	 *            联系人电话
	 */
	public void setContactPhoneNumber(String contactPhoneNumber) {
		this.contactPhoneNumber = contactPhoneNumber;
	}

	/**
	 * 获取联系的e-mail
	 * 
	 * @return e-mail
	 */
	public String getContacteEMail() {
		return contacteEMail;
	}

	/**
	 * 设置联系的e-mail
	 * 
	 * @param contacteEMail
	 *            e-mail
	 */
	public void setContacteEMail(String contacteEMail) {
		this.contacteEMail = contacteEMail;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName
				+ ", companyAddress=" + companyAddress + ", contactPersonName="
				+ contactPersonName + ", contactPhoneNumber="
				+ contactPhoneNumber + ", contacteEMail=" + contacteEMail + "]";
	}

}
