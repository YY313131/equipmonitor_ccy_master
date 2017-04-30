package com.ccy.service.Impl;

import java.util.List;

import com.ccy.bean.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccy.dao.DeviceDao;
import com.ccy.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {

	@Autowired
	private DeviceDao deviceDao;

	private DeviceServiceImpl() {
	}

	public boolean add(Device device) {
		if (device == null)
			throw new NullPointerException("device");

		return getByNo(device.getDeviceNo()) == null ? deviceDao.add(device) > 0
				: false;
	}

	public boolean deleteById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return deviceDao.deleteById(id) > 0;
	}

	public boolean deleteByNo(String deviceNo) {
		if (deviceNo == null || deviceNo.length() == 0)
			throw new IllegalArgumentException("deviceNo is null or empty");
		return deviceDao.deleteByNo(deviceNo) > 0;
	}

	public int deleteByCompanyId(int companyId) {
		if (companyId <= 0)
			throw new IllegalArgumentException("companyId<=0");
		return deviceDao.deleteByCompanyId(companyId);
	}

	public boolean update(Device device) {
		if (device == null)
			throw new NullPointerException("device");
		return deviceDao.update(device) > 0;
	}

	public Device getById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return deviceDao.getById(id);
	}

	public Device getByNo(String deviceNo) {
		if (deviceNo == null || deviceNo.length() == 0)
			throw new IllegalArgumentException("deviceNo is null or empty");
		return deviceDao.getByNo(deviceNo);
	}

	public List<Device> getByCompanyId(int companyId) {
		if (companyId <= 0)
			throw new IllegalArgumentException("companyId<=0");
		return deviceDao.getByCompanyId(companyId);
	}

}
