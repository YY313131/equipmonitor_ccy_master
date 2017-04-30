package com.ccy.service;

import com.ccy.bean.Company;

import java.util.List;

public interface CompanyService {

	/**
	 * 添加一条公司信息
	 * 
	 * @param company
	 *            公司
	 * @return true，添加成功；false，添加失败
	 */
	boolean add(Company company);

	/**
	 * 删除指定id的公司信息
	 * 
	 * @param id
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteById(int id);

	/**
	 * 删除指定名称的公司信息
	 * 
	 * @param companyName
	 *            公司名称
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteByName(String companyName);

	/**
	 * 更新指定id的公司信息
	 * 
	 * @param company
	 * @return true，更新成功；false，更新失败
	 */
	boolean update(Company company);

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
	Company getByName(String companyName);

}
