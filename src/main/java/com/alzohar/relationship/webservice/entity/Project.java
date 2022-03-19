package com.alzohar.relationship.webservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee_project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "relationship_generator")
	@SequenceGenerator(name = "relationship_generator", initialValue = 1, allocationSize = 1, sequenceName = "customer_seq")
	@Column(name = "project_id")
	private long id;

	@Column(name = "name")
	private String name;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "employee_project_mapping", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
//	List<Employee> employee;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
