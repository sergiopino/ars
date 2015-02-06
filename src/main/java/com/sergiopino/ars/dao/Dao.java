package com.sergiopino.ars.dao;

import java.util.List;

import com.sergiopino.ars.entity.Entity;


public interface Dao<T extends Entity, I>
{

	List<T> findAll();


	T find(I id);


	T save(T newsEntry);
	
	void persist(T newsEntry);


	void delete(I id);

}