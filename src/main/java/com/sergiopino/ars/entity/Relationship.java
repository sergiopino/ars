package com.sergiopino.ars.entity;

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
public class Relationship implements Entity
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5991608766394392821L;

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String type;

	@OneToMany(mappedBy="relationship", fetch=FetchType.LAZY)
	private List<Account> relationships;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="FK_COMPANY_ID")
	private Company company;

	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="REF_RELATIONSHIP_ID")
	private Relationship referenceRelationship;
	
	@OneToMany(mappedBy="relationship", fetch=FetchType.LAZY)
	private List<Note> notes;


	public Relationship() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public List<Account> getRelationships() {
		return relationships;
	}


	public void setRelationships(List<Account> relationships) {
		this.relationships = relationships;
	}


	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}


	public Relationship getReferenceRelationship() {
		return referenceRelationship;
	}


	public void setReferenceRelationship(Relationship referenceRelationship) {
		this.referenceRelationship = referenceRelationship;
	}


	public List<Note> getNotes() {
		return notes;
	}


	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}


}