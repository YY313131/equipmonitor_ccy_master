package com.ccy.service;

import com.ccy.bean.CollectParameter;
import com.ccy.bean.Collector;

import java.util.List;

public interface CollectorService {

	/**
	 * 添加采集器
	 * 
	 * @param collector
	 * @return true，添加成功；false，添加失败
	 */
	boolean add(Collector collector);

	/**
	 * 添加一个采集参数的信息
	 * 
	 * @param collectParameter
	 * @return true，添加成功；false，添加失败
	 */
	boolean addCollectParameter(CollectParameter collectParameter);

	/**
	 * 删除指定id的采集器
	 * 
	 * @param id
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteById(int id);

	/**
	 * 删除指定指定设备的采集器
	 *
	 * @param deviceId
	 * @return true，删除成功；false，删除失败
	 */
	int deleteByDeviceId(int deviceId);

	/**
	 * 删除采集器中的一条采集参数信息
	 * 
	 * @param collectorId
	 *            采集器id
	 * @param subsystemId
	 *            子系统id
	 * @param parameterId
	 *            采集参数id
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteCollectParameter(int collectorId, int subsystemId,
                                   int parameterId);

	/**
	 * 删除采集器中的一条采集参数信息
	 * 
	 * @param collectParameter
	 * @return true，删除成功；false，删除失败
	 */
	boolean deleteCollectParameter(CollectParameter collectParameter);

	/**
	 * 删除指定id的采集器的所有采集参数信息
	 * 
	 * @param collectorId
	 * @return 影响数据库的条数
	 */
	int deleteCollectorParametersByCollectorId(int collectorId);

	/**
	 * 更新指定id的采集器
	 * 
	 * @param collecotr
	 * @return true，更新成功；false，更新失败
	 */
	boolean update(Collector collecotr);

	/**
	 * 获取指定id的采集器
	 * 
	 * @param id
	 * @return 采集器
	 */
	Collector getById(int id);

	/**
	 * 获取指定指定设备的所有采集器
	 * 
	 * @param companyId
	 * @param deviceId
	 * @return 采集器集合
	 */
	List<Collector> getByDeviceId(int deviceId);

	/**
	 * 获取指定公司的所有采集器
	 * 
	 * @param companyId
	 * @return 采集器集合
	 */
	List<Collector> getByCompanyId(int companyId);

	/**
	 * 获取指定子系统的指定参数的采集参数信息
	 * 
	 * @param subsystemId
	 * @param parameterId
	 * @return 采集器
	 */
	CollectParameter getBySubsystemIdAndParameterId(int subsystemId,
                                                    int parameterId);

	/**
	 * 获取采集器的所有采集参数
	 * 
	 * @param collectorId
	 * @return
	 */
	List<CollectParameter> getCollectParameters1(int collectorId);

	/**
	 * 获取采集器才有的所有指定子系统的采集参数
	 * 
	 * @param collectorId
	 * @param subsystemId
	 * @return
	 */
	List<CollectParameter> getCollectParameters2(int collectorId,
                                                 int subsystemId);

}
