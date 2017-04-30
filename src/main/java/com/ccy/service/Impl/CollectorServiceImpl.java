package com.ccy.service.Impl;

import java.util.List;

import com.ccy.bean.CollectParameter;
import com.ccy.bean.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccy.dao.CollectorDao;
import com.ccy.service.CollectorService;

@Service
public class CollectorServiceImpl implements CollectorService {

	@Autowired
	private CollectorDao collectorDao;

	private CollectorServiceImpl() {
	}

	public boolean add(Collector collector) {
		if (collector == null)
			throw new NullPointerException("collector");
		return collectorDao.add(collector) > 0;
	}

	public boolean addCollectParameter(CollectParameter collectParameter) {
		if (collectParameter == null)
			throw new NullPointerException("collectParameter");
		try {
			return collectorDao.addCollectParameter(collectParameter) > 0;
		} catch (Exception ignore) {// 主键冲突
		}
		return false;
	}

	public boolean deleteById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return collectorDao.deleteById(id) > 0;
	}

	public int deleteByDeviceId(int deviceId) {
		if (deviceId <= 0)
			throw new IllegalArgumentException("deviceId<=0");
		return collectorDao.deleteByDeviceId(deviceId);
	}

	public boolean deleteCollectParameter(int collectorId, int subsystemId,
			int parameterId) {
		if (collectorId <= 0 || subsystemId <= 0 || parameterId <= 0)
			throw new IllegalArgumentException("parameter<=0");
		return collectorDao.deleteCollectParameter(collectorId, subsystemId,
				parameterId) > 0;
	}

	public boolean deleteCollectParameter(CollectParameter collectParameter) {
		if (collectParameter == null)
			throw new NullPointerException("collectParameter");
		return deleteCollectParameter(collectParameter.getCollectorId(),
				collectParameter.getSubsystemId(),
				collectParameter.getParameterId());
	}

	public int deleteCollectorParametersByCollectorId(int collectorId) {
		if (collectorId <= 0)
			throw new IllegalArgumentException("collectorId<=0");
		return collectorDao.deleteCollectorParametersByCollectorId(collectorId);
	}

	public boolean update(Collector collecotr) {
		if (collecotr == null)
			throw new NullPointerException("collector");
		return collectorDao.update(collecotr) > 0;
	}

	public Collector getById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return collectorDao.getById(id);
	}

	public List<Collector> getByDeviceId(int deviceId) {
		if (deviceId <= 0)
			throw new IllegalArgumentException("deviceId<=0");
		return collectorDao.getByDeviceId(deviceId);
	}

	public List<Collector> getByCompanyId(int companyId) {
		if (companyId <= 0)
			throw new IllegalArgumentException("companyId<=0");
		return collectorDao.getByCompanyId(companyId);
	}

	public CollectParameter getBySubsystemIdAndParameterId(int subsystemId,
			int parameterId) {
		if (subsystemId <= 0 || parameterId <= 0)
			throw new IllegalArgumentException("parameter<=0");
		return collectorDao.getBySubsystemIdAndParameterId(subsystemId,
				parameterId);
	}

	public List<CollectParameter> getCollectParameters1(int collectorId) {
		if (collectorId <= 0)
			throw new IllegalArgumentException("collectorId<=0");
		return collectorDao.getCollectParameters1(collectorId);
	}

	public List<CollectParameter> getCollectParameters2(int collectorId,
			int subsystemId) {
		if (collectorId <= 0 || subsystemId <= 0)
			throw new IllegalArgumentException("parameter<=0");
		return collectorDao.getCollectParameters2(collectorId, subsystemId);
	}

}
