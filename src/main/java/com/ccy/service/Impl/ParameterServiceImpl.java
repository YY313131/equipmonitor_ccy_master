package com.ccy.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.ccy.bean.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccy.dao.ParameterDao;
import com.ccy.service.ParameterService;

@Service
public class ParameterServiceImpl implements ParameterService {

//	private List<Parameter> parameters=new ArrayList<Parameter>(16);

	private Map<Integer,Parameter>parameterMap=new ConcurrentHashMap<Integer, Parameter>(16);
	@Autowired
	private ParameterDao parameterDao;

	private ParameterServiceImpl() {
	}

	public boolean add(Parameter parameter) {
		if (parameter == null)
			throw new NullPointerException("parameter");
		return parameterDao.add(parameter) > 0;
	}

	public boolean deleteById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return parameterDao.deleteById(id) > 0;
	}

	public boolean update(Parameter parameter) {
		if (parameter == null)
			throw new NullPointerException("parameter");
		return parameterDao.update(parameter) > 0;
	}

	public Parameter getById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		Parameter parameter= parameterMap.get(id);

        if(parameter == null){
            parameter = parameterDao.getById(id);
			parameterMap.put(id, parameter);
        }
		return parameter;
	}

	public List<Parameter> getByCompanyId(int companyId) {
		if (companyId <= 0)
			throw new IllegalArgumentException("companyId<=0");
		return parameterDao.getByCompanyId(companyId);
	}

	public List<Parameter> getBySubsystemId(int subsystemId) {
		if (subsystemId <= 0)
			throw new IllegalArgumentException("subsystemId<=0");
		return parameterDao.getBySubsystemId(subsystemId);
	}

}
