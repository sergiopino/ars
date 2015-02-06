package com.sergiopino.ars.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonView;

import com.sergiopino.ars.JsonViews;


@javax.persistence.Entity
public class Company implements Entity{

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
	private String address;

	@OneToMany(mappedBy="company", fetch=FetchType.LAZY)
	private List<Relationship> relationships;
	
	@OneToOne(fetch=FetchType.LAZY)
	  @JoinColumn(name="REF_COMPANY_ID")
	private Company referenceCompany;

	@OneToMany(mappedBy="company")
	private List<Note> notes;
	
	public Company() {
		// TODO Auto-generated constructor stub
	}

	@JsonView(JsonViews.Admin.class)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@JsonView(JsonViews.User.class)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@JsonView(JsonViews.User.class)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@JsonIgnore
	public List<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}

	@JsonIgnore
	public Company getReferenceCompany() {
		return referenceCompany;
	}

	public void setReferenceCompany(Company referenceCompany) {
		this.referenceCompany = referenceCompany;
	}

	@JsonIgnore
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

//	@JsonIgnore
//	public Company getLazyCompany() {
//		Company company = new Company();
//		company.setId(id);
//		company.setName(name);
//		company.setAddress(address);
//		return company;
//	}

	@Override
	public String toString()
	{
		return String.format("Company[%d, %s]", this.id, this.name);
	}
	
}