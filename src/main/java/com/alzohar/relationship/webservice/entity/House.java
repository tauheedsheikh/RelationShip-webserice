package com.alzohar.relationship.webservice.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "relationship_house")
public class House {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "relationship_generator")
	@SequenceGenerator(name = "relationship_generator", initialValue = 1, allocationSize = 1, sequenceName = "house_seq")

	private long id;

	@Column(name = "area")
	private String area;

	@Column(name = "land_mark")
	private String landmark;

	@Column(name = "city")
	private String city;

	@Column(name = "modified_at")
	private Date modifiedAt = new Date();

	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
