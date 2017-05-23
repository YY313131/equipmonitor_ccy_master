package com.ccy.service;

import java.util.Date;
import java.util.List;

import com.ccy.dto.CollectedValue;
import com.ccy.netty.CCYCollectedData;

public interface CollectedDataService {

	/**
	 * 向指定数据表添加数据
	 *
	 * @param collectedData
	 * @return true，数据添加成功；false，数据添加失败
	 */
	boolean add(CCYCollectedData collectedData);

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

	/**
	 * 根绝子系统id，参数id，获取参数最新值
	 * @return
	 */
	CollectedValue getCurrentValueById(int subsystemId,int parameterId);
}
