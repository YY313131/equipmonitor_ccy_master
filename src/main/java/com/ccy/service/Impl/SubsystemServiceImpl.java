package com.ccy.service.Impl;

import java.util.List;

import com.ccy.bean.Subsystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccy.dao.SubsystemDao;
import com.ccy.service.SubsystemService;

@Service
public class SubsystemServiceImpl implements SubsystemService {

	@Autowired
	private SubsystemDao subsystemDao;

	private SubsystemServiceImpl() {
	}

	public boolean add(Subsystem subsystem) {
		if (subsystem == null)
			throw new NullPointerException("subsystem");
		return subsystemDao.add(subsystem) > 0;
	}

	public boolean addParameter(int subsystemId, int parameterId) {
		if (subsystemId <= 0 || parameterId <= 0)
			throw new IllegalArgumentException("id<=0");
		try {
			return subsystemDao.addParameter(subsystemId, parameterId) > 0;
		} catch (Exception ignore) { // 主键冲突
		}
		return false;
	}

	public boolean deleteById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return subsystemDao.deleteById(id) > 0;
	}

	public int deleteByDeviceId(int deviceId) {
		if (deviceId <= 0)
			throw new IllegalArgumentException("deviceId<=0");
		return subsystemDao.deleteByDeviceId(deviceId);
	}

	public boolean deleteParameter(int subsystemId, int parameterId) {
		if (subsystemId <= 0 || parameterId <= 0)
			throw new IllegalArgumentException("id<=0");
		return subsystemDao.deleteParameter(subsystemId, parameterId) > 0;
	}

	public int deleteParametersBySubsystemId(int subsystemId) {
		if (subsystemId <= 0)
			throw new IllegalArgumentException("subsystemId<=0");
		return subsystemDao.deleteParametersBySubsystemId(subsystemId);
	}

	public boolean update(Subsystem subsystem) {
		if (subsystem == null)
			throw new NullPointerException("subsystem");
		return subsystemDao.update(subsystem) > 0;
	}

	public Subsystem getById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return subsystemDao.getById(id);
	}

	public List<Subsystem> getByDeviceId(int deviceId) {
		if (deviceId <= 0)
			throw new IllegalArgumentException("deviceId<=0");
		return subsystemDao.getByDeviceId(deviceId);
	}

}
