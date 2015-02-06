package com.sergiopino.ars.dao.user;

import com.sergiopino.ars.dao.Dao;
import com.sergiopino.ars.entity.User;


public interface UserDao extends Dao<User, Long>
{

	User findByName(String name);

}