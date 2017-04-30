package com.ccy.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ccy.bean.CollectParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccy.dao.CollectedDataDao;
import com.ccy.dao.CollectorDao;
import com.ccy.dto.CollectedValue;
import com.ccy.service.CollectedDataService;

@Service
public class CollectedDataServiceImpl implements CollectedDataService {

	private static final String DataTableNamePrefix = "collecteddata";

	@Autowired
	private CollectorDao collectorDao;

	@Autowired
	private CollectedDataDao collectedDataDao;

	private Map<String, String> tableNames = new ConcurrentHashMap<String, String>(160);

	private CollectedDataServiceImpl() {
	}

	public boolean add(int collectorId, List<Double> values) {
		String tableName = getTableName(collectorId);
		return tableName == null ? false : collectedDataDao.add(tableName, values) > 0;
	}

	public List<CollectedValue> getAfter(int subsystemId, int parameterId, Date beginTime) {
		String tableName = getTableName(subsystemId, parameterId);
		String fieldName = getFieldName(subsystemId, parameterId);
		return tableName == null || fieldName == null ? null
				: collectedDataDao.getAfter(tableName, fieldName, beginTime);
	}

	public List<CollectedValue> getAfter(int deviceId, int subsystemId, int parameterId,
								  Date beginTime){
		String tableName = getTableName(deviceId);
		String fieldName = getFieldName(subsystemId, parameterId);
		return tableName == null || fieldName == null ? null
				: collectedDataDao.getAfter(tableName, fieldName, beginTime);
	}

	public List<CollectedValue> getBetween(int subsystemId, int parameterId, Date beginTime, Date endTime) {
		String tableName = getTableName(subsystemId, parameterId);
		String fieldName = getFieldName(subsystemId, parameterId);
		return tableName == null || fieldName == null ? null
				: collectedDataDao.getBetween(tableName, fieldName, beginTime, endTime);
	}

	public List<CollectedValue> getBetween(int deviceId, int subsystemId, int parameterId,
									Date beginTime, Date endTime){
		String tableName = getTableName(deviceId);
		String fieldName = getFieldName(subsystemId, parameterId);
		return tableName == null || fieldName == null ? null
				: collectedDataDao.getBetween(tableName, fieldName, beginTime, endTime);
	}

	private String getTableName(int deviceId) {
		return DataTableNamePrefix + deviceId;
	}

	private String getTableName(int subsystemId, int parameterId) {
		String tableName = null;
		String key = subsystemId + "_" + parameterId;
		if (tableNames.containsKey(key)) {
			tableName = tableNames.get(key);
		} else {
			CollectParameter cp = collectorDao.getBySubsystemIdAndParameterId(subsystemId, parameterId);
			if (cp != null) {
				tableName = getTableName(cp.getDeviceId());
				if (tableName != null) {
					tableNames.put(key, tableName);
				}
			}
		}
		return tableName;
	}

	private String getFieldName(int subsystemId, int parameterId) {
		return "p" + subsystemId + "_" + parameterId;
	}
}
