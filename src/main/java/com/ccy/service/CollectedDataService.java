package com.ccy.service;

import java.util.Date;
import java.util.List;

import com.ccy.dto.CollectedValue;

public interface CollectedDataService {

	/**
	 * 向指定数据表添加数据
	 *
	 * @param values
	 * @return true，数据添加成功；false，数据添加失败
	 */
	boolean add(int collectorId, List<Double> values);

	/**
	 * 获取指定数据表里指定字段在某个时间之后的所有数据
	 * 
	 * @param subsystemId
	 * @param parameterId
	 * @param beginTime
	 * @return 数据集合
	 */
	List<CollectedValue> getAfter(int subsystemId, int parameterId,
                                  Date beginTime);

	/**
	 * 获取指定数据表里指定字段在某个时间之后的所有数据
	 *
	 * @param subsystemId
	 * @param parameterId
	 * @param beginTime
	 * @return 数据集合
	 */
	List<CollectedValue> getAfter(int deviceId, int subsystemId, int parameterId,
								  Date beginTime);

	/**
	 * 获取指定数据表里指定字段在某个时间段的所有数据
	 * 
	 * @param subsystemId
	 * @param parameterId
	 * @param beginTime
	 * @param endTime
	 * @return 数据集合
	 */
	List<CollectedValue> getBetween(int subsystemId, int parameterId,
                                    Date beginTime, Date endTime);

	/**
	 * 获取指定数据表里指定字段在某个时间段的所有数据
	 *
	 * @param subsystemId
	 * @param parameterId
	 * @param beginTime
	 * @param endTime
	 * @return 数据集合
	 */
	List<CollectedValue> getBetween(int deviceId, int subsystemId, int parameterId,
									Date beginTime, Date endTime);
}
