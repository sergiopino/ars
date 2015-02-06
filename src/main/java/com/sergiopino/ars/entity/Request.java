package com.sergiopino.ars.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@javax.persistence.Entity
public class Request implements Entity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5991608766394392821L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String name;

	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="FK_COMPANY_ID")
	private Company company;
	
	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="FK_RELATIONSHIP_ID")
	private Relationship relationships;

	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="FK_ACCOUNT_ID")
	private Account account;

	public Request() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Relationship getRelationships() {
		return relationships;
	}

	public void setRelationships(Relationship relationships) {
		this.relationships = relationships;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	
}