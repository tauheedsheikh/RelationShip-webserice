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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "relations_employee")

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "relations_generator")
	@SequenceGenerator(name = "relations_generator", initialValue = 1, allocationSize = 1, sequenceName = "relation_seq")

	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "dept")
	private String dept;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private int age;

	@Column(name = "phone")
	private long phone;

	@Column(name = "salary")
	private double salary;

	@Column(name = "address")
	private String address;

	@Column(name = "modified_at")
	private Date modifiedAt = new Date();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "employee_project_mapping", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	List<Project> project;

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

}
