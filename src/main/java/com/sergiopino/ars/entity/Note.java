package com.sergiopino.ars.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@javax.persistence.Entity
public class Note implements Entity
{

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Date date;

	@Column
	private String content;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACCOUNT_ID")
	private Account account;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RELATIONSHIP_ID")
	private Relationship relationship;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPANY_ID")
	private Company company;


	public Note()
	{
		this.date = new Date();
	}




}