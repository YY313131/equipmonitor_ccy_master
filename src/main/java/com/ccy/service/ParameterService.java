package com.ccy.service;

import com.ccy.bean.Parameter;

import java.util.List;

public interface ParameterService {

	/**
	 * 添加一个参数
	 * 
	 * @param parameter
	 * @return true，添加成功；false，添加失败
	 */
	boolean add(Parameter parameter);

	/**
	 * 删除指定id的参数
	 * 
	 * @param id
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteById(int id);

	/**
	 * 更新参数
	 * 
	 * @param parameter
	 * @return true，更新成功；false，更新失败
	 */
	boolean update(Parameter parameter);

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
