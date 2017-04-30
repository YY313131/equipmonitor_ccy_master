package com.ccy.service;

import com.ccy.bean.Subsystem;

import java.util.List;

public interface SubsystemService {

	/**
	 * 添加子系统，不会向数据库添加与采集参数的关系
	 * 
	 * @param subsystem
	 * @return true，添加成功；false，添加失败
	 */
	boolean add(Subsystem subsystem);

	/**
	 * 添加一条子系统与采集参数的关系项
	 * 
	 * @param subsystemId
	 * @param parameterId
	 * @return true，添加成功；false，添加失败
	 */
	boolean addParameter(int subsystemId, int parameterId);

	/**
	 * 删除指定id的子系统
	 * 
	 * @param id
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteById(int id);

	/**
	 * 山吃指定涉笔的所有子系统
	 * 
	 * @param deviceId
	 * @return 影响数据库的条数
	 */
	int deleteByDeviceId(int deviceId);

	/**
	 * 删除一条子系统与采集参数的关系项
	 * 
	 * @param subsystemId
	 * @param parameterId
	 * @return true，添加成功；false，添加失败
	 */
	boolean deleteParameter(int subsystemId, int parameterId);

	/**
	 * 删除一条子系统与采集参数的关系项
	 * 
	 * @param subsystemId
	 * @return 影响数据库的条数
	 */
	int deleteParametersBySubsystemId(int subsystemId);

	/**
	 * 更新子系统
	 * 
	 * @param subsystem
	 * @return true，更新成功；false，更新失败
	 */
	boolean update(Subsystem subsystem);

	/**
	 * 获取指定id的子系统
	 * 
	 * @param id
	 * @return 子系统
	 */
	Subsystem getById(int id);

	/**
	 * 获取指定设备的所有子系统
	 * 
	 * @param deviceId
	 * @return 子系统集合
	 */
	List<Subsystem> getByDeviceId(int deviceId);

}
