package com.ccy.service;

import com.ccy.bean.Device;

import java.util.List;

public interface DeviceService {

	/**
	 * 添加一个设备信息信息
	 * 
	 * @param device
	 * @return true，添加成功；false，添加失败
	 */
	boolean add(Device device);

	/**
	 * 删除指定id的设备，将级联删除该设备下的所有子系统
	 * 
	 * @param id
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteById(int id);

	/**
	 * 删除指定编号的设备，将级联删除该设备下的所有子系统
	 * 
	 * @param deviceNo
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteByNo(String deviceNo);

	/**
	 * 删除指定公司的所有设备，将级联删除该设备下的所有子系统
	 * 
	 * @param companyId
	 * @return 删除的设备数
	 */
	int deleteByCompanyId(int companyId);

	/**
	 * 更新指定id的设备信息
	 *
	 * @param device
	 * @return true，更新成功；false，更新失败
	 */
	boolean update(Device device);

	/**
	 * 获取指定id的设备
	 * 
	 * @param id
	 * @return 设备
	 */
	Device getById(int id);

	/**
	 * 获取指定编号的设备
	 * 
	 * @param deviceNo
	 * @return 设备
	 */
	Device getByNo(String deviceNo);

	/**
	 * 获取指定公司的所有设备
	 * 
	 * @param companyId
	 * @return 设备集合
	 */
	List<Device> getByCompanyId(int companyId);

}
