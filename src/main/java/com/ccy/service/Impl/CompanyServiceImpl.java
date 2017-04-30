package com.ccy.service.Impl;

import java.util.List;

import com.ccy.bean.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccy.dao.CompanyDao;
import com.ccy.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	private CompanyServiceImpl() {
	}

	public boolean add(Company company) {
		if (company == null)
			throw new NullPointerException("company");
		return companyDao.add(company) > 0;
	}

	public boolean deleteById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return companyDao.deleteById(id) > 0;
	}

	public boolean deleteByName(String companyName) {
		if (companyName == null || companyName.length() == 0)
			throw new IllegalArgumentException("companyName is null or empty");
		return companyDao.deleteByName(companyName) > 0;
	}

	public boolean update(Company company) {
		if (company == null)
			throw new NullPointerException("company");
		return companyDao.update(company) > 0;
	}

	public List<Company> getAll() {
		return companyDao.getAll();
	}

	public Company getById(int id) {
		if (id <= 0)
			throw new IllegalArgumentException("id<=0");
		return companyDao.getById(id);
	}

	public Company getByName(String companyName) {
		if (companyName == null || companyName.length() == 0)
			throw new IllegalArgumentException("companyName is null or empty");
		List<Company> companys = companyDao.getByName(companyName);
		if (companys == null || companys.size() == 0)
			return null;
		return companys.get(0);
	}

}
