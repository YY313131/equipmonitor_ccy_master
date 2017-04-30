package com.ccy.dao;

import com.ccy.bean.Company;

import java.util.List;

public interface CompanyDao {

	/**
	 * 添加一条公司信息
	 * 
	 * @param company
	 *            公司
	 * @return 影响数据库的条数
	 */
	int add(Company company);

	/**
	 * 删除指定id的公司信息
	 * 
	 * @param id
	 * @return 影响数据库的条数
	 */
	int deleteById(int id);

	/**
	 * 删除指定名称的公司信息
	 * 
	 * @param companyName
	 *            公司名称
	 * @return 影响数据库的条数
	 */
	int deleteByName(String companyName);

	/**
	 * 更新指定id的公司信息
	 * 
	 * @param company
	 * @return 影响数据库的条数
	 */
	int update(Company company);

	/**
	 * 获取所有的公司信息
	 * 
	 * @return 公司集合
	 */
	List<Company> getAll();

	/**
	 * 获取指定id的公司信息
	 * 
	 * @param id
	 * @return 公司
	 */
	Company getById(int id);

	/**
	 * 获取指定名称的公司信息，支持模糊查询
	 * 
	 * @param companyName
	 *            公司名称
	 * @return 公司
	 */
	List<Company> getByName(String companyName);

}
