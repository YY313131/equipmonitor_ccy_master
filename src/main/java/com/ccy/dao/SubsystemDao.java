package com.ccy.dao;

import java.util.List;

import com.ccy.bean.Subsystem;
import org.apache.ibatis.annotations.Param;

public interface SubsystemDao {

	/**
	 * 添加子系统
	 * 
	 * @param subsystem
	 * @return 影响数据库的条数
	 */
	int add(Subsystem subsystem);

	/**
	 * 添加一条子系统与采集参数的关系项
	 * 
	 * @param subsystemId
	 * @param parameterId
	 * @return 影响数据库的条数
	 */
	int addParameter(@Param("subsystemId") int subsystemId,
                     @Param("parameterId") int parameterId);

	/**
	 * 删除指定id的子系统
	 * 
	 * @param id
	 * @return 影响数据库的条数
	 */
	int deleteById(int id);

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
	 * @return 影响数据库的条数
	 */
	int deleteParameter(@Param("subsystemId") int subsystemId,
                        @Param("parameterId") int parameterId);

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
	 * @return 影响数据库的条数
	 */
	int update(Subsystem subsystem);

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
