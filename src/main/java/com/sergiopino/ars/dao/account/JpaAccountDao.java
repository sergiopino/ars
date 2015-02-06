package com.sergiopino.ars.dao.account;

import org.springframework.stereotype.Repository;

import com.sergiopino.ars.dao.JpaDao;
import com.sergiopino.ars.entity.Account;

@Repository("accountDao")
public class JpaAccountDao extends JpaDao<Account, Long> implements AccountDao
{

	public JpaAccountDao()
	{
		super(Account.class);
	}


}
