package com.ccy.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ccy.dto.CollectedValue;

public interface CollectedDataDao {

	/**
	 * 向指定数据表添加数据
	 * 
	 * @param tableName
	 * @param values
	 * @return 数据库受影响的行数
	 */
	int add(@Param("tableName") String tableName,
			@Param("fields") List<String> fields,
            @Param("values") List<Double> values);

	/**
	 * 获取指定数据表里指定字段在某个时间之后的所有数据
	 * 
	 * @param tableName
	 * @param fieldName
	 * @param beginTime
	 * @return 数据集合
	 */
	List<CollectedValue> getAfter(@Param("tableName") String tableName,
                                  @Param("fieldName") String fieldName,
                                  @Param("beginTime") Date beginTime);

	/**
	 * 获取指定数据表里指定字段在某个时间段的所有数据
	 * 
	 * @param tableName
	 * @param fieldName
	 * @param beginTime
	 * @param endTime
	 * @return 数据集合
	 */
	List<CollectedValue> getBetween(@Param("tableName") String tableName,
                                    @Param("fieldName") String fieldName,
                                    @Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

	/**
	 * 获取指定子系统下面某个参数的最新值
	 * @param tableName
	 * @param fieldName
	 * @return
	 */
	CollectedValue getCurrentValue(@Param("tableName") String tableName,
								   @Param("fieldName") String fieldName);

	/**
	 * 获取指定子系统下面某个参数的最新值
	 *
	 * @param tableName
	 * @param fieldName
	 * @return
	 */
	CollectedValue getTopOn(@Param("tableName") String tableName,
							@Param("fieldName") String fieldName);
}
