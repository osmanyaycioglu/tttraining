package com.tt.training.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Entity
@XmlRootElement
@Table(name = "calisan")
@SecondaryTable(name = "calisanextra")
public class Employee {

//	@EmbeddedId
//	private CompoundId comId;

	@Id
	@GeneratedValue
	private long id;

	@NotBlank(message = "boş gönderemezsin")
	@Size(max = 30)
	private String name;

	@Column(length = 33, name = "soyisim", unique = true, nullable = false)
	private String surname;

	@Max(150)
	@Min(5)
	@Column(table = "calisanextra")
	private int age;

	@Column(table = "calisanextra")
	private String extra;

	@Transient
	private String myLocalVar;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Department department;

	@Embedded
	private MyEmbeddedObj obj;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "employee")
	private List<Adres> adresler;

	@PrePersist
	@PreUpdate
	@PreRemove
	public void preActions() {
		System.out.println("PrePersist");
	}

	@PostPersist
	@PostUpdate
	@PostRemove
	@PostLoad
	public void postActions() {
		System.out.println("PostPersist");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public List<Adres> getAdresler() {
		return adresler;
	}

	public void setAdresler(List<Adres> adresler) {
		this.adresler = adresler;
	}

	public MyEmbeddedObj getObj() {
		return obj;
	}

	public void setObj(MyEmbeddedObj obj) {
		this.obj = obj;
	}

}
