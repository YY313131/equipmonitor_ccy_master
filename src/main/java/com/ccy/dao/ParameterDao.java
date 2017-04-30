package com.ccy.dao;

import com.ccy.bean.Parameter;

import java.util.List;

public interface ParameterDao {

	/**
	 * 添加一个参数
	 * 
	 * @param parameter
	 * @return 数据库受影响的条数
	 */
	int add(Parameter parameter);

	/**
	 * 删除指定id的参数
	 * 
	 * @param id
	 * @return 数据库受影响的条数
	 */
	int deleteById(int id);

	/**
	 * 更新参数
	 * 
	 * @param parameter
	 * @return 数据库受影响的条数
	 */
	int update(Parameter parameter);

	/**
	 * 获取指定id的参数信息
	 * 
	 * @param id
	 * @return 采集参数
	 */
	Parameter getById(int id);

	/**
	 * 获取指定公司的所有参数
	 * 
	 * @param companyId
	 * @return 参数集合
	 */
	List<Parameter> getByCompanyId(int companyId);

	/**
	 * 获取指定子系统的所有参数
	 * 
	 * @param subsystemId
	 * @return 参数集合
	 */
	List<Parameter> getBySubsystemId(int subsystemId);
}
