package com.sergiopino.ars.dao.relationship;

import org.springframework.stereotype.Repository;

import com.sergiopino.ars.dao.JpaDao;
import com.sergiopino.ars.entity.Relationship;

@Repository("relationshipDao")
public class JpaRelationshipDao extends JpaDao<Relationship, Long> implements RelationshipDao
{

	public JpaRelationshipDao()
	{
		super(Relationship.class);
	}


}
