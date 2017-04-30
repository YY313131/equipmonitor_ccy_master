package com.ccy.dao;

import com.ccy.bean.Device;

import java.util.List;

public interface DeviceDao {

	/**
	 * 添加一个设备信息信息
	 * 
	 * @param device
	 * @return 影响数据库的条数
	 */
	int add(Device device);

	/**
	 * 删除指定id的设备，将级联删除该设备下的所有子系统
	 * 
	 * @param id
	 * @return 影响数据库的条数
	 */
	int deleteById(int id);

	/**
	 * 删除指定编号的设备，将级联删除该设备下的所有子系统
	 * 
	 * @param deviceNo
	 * @return 影响数据库的条数
	 */
	int deleteByNo(String deviceNo);

	/**
	 * 删除指定公司的所有设备，将级联删除该设备下的所有子系统
	 * 
	 * @param companyId
	 * @return 影响数据库的条数
	 */
	int deleteByCompanyId(int companyId);

	/**
	 * 更新指定id的设备信息
	 *
	 * @param device
	 * @return 影响数据库的条数
	 */
	int update(Device device);

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
