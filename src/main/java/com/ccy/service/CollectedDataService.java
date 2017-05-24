package com.ccy.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
	 * 获取某个子系统下的所有参数的最新数据
	 *
	 * @param subsystemId
	 * @return
	 */
	Map<Integer, CollectedValue> getTopOnes(int subsystemId);


	/**
	 * 获取指定子系统下某个参数的最新值
	 *
	 * @param subsystemId
	 * @param parameterId
	 * @return
	 */
	CollectedValue getTopOne(int subsystemId, int parameterId);


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
	 * 根据子系统id，参数id，获取参数最新值
	 * @return
	 */
	CollectedValue getCurrentValueById(int subsystemId,int parameterId);

	/**
	 * 获取参数列表
	 * @return
	 */
	List<CollectedValue> getDefaultValueList(int subsystemId,int parameterId,int offset);

    /**
     * 获取某一天的参数值
     * @param subsystemId
     * @param parameterId
     * @param date
     * @param timestamp 时间间隔
     * @return
     */
	List<CollectedValue> getDayValueList(int subsystemId,int parameterId,Date date,int timestamp);
}
