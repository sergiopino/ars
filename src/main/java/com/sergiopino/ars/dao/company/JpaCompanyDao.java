package com.sergiopino.ars.dao.company;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sergiopino.ars.dao.JpaDao;
import com.sergiopino.ars.entity.Company;

@Repository("companyDao")
public class JpaCompanyDao extends JpaDao<Company, Long> implements CompanyDao
{

	public JpaCompanyDao()
	{
		super(Company.class);
	}

	
//	@Override
//	public List<Company> findAll() {
//		// TODO Auto-generated method stub
//		List<Company> lazyList = new ArrayList<Company>();
//		List<Company> all = super.findAll();
//		for (Company company : all) {
//			lazyList.add(company.getLazyCompany());
//		}
//		return lazyList;
//		
//	}

}
