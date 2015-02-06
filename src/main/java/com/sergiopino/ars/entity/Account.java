package com.sergiopino.ars.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@javax.persistence.Entity
public class Account implements Entity
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

	@Column
	private String currency;

	@Column
	private String owner;

	@Column
	private BigDecimal balance;

	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="REF_ACCOUNT_ID")
	private Account referenceAccount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_RELATIONSHIP_ID")
	private Relationship relationship;
	
	@OneToMany(mappedBy="account")
	private List<Note> notes;
	

	public Account() {
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Account getReferenceAccount() {
		return referenceAccount;
	}
	
	public void setReferenceAccount(Account referenceAccount) {
		this.referenceAccount = referenceAccount;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	

}