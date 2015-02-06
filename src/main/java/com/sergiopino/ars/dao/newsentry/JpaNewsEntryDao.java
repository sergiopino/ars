package com.sergiopino.ars.dao.newsentry;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sergiopino.ars.dao.JpaDao;
import com.sergiopino.ars.entity.NewsEntry;

@Repository("newsDao")
public class JpaNewsEntryDao extends JpaDao<NewsEntry, Long> implements NewsEntryDao
{

	public JpaNewsEntryDao()
	{
		super(NewsEntry.class);
	}


	@Override
	@Transactional(readOnly = true)
	public List<NewsEntry> findAll()
	{
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<NewsEntry> criteriaQuery = builder.createQuery(NewsEntry.class);

		Root<NewsEntry> root = criteriaQuery.from(NewsEntry.class);
		criteriaQuery.orderBy(builder.desc(root.get("date")));

		TypedQuery<NewsEntry> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

}
