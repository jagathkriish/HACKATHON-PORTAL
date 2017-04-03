package com.vv.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profile implements Serializable {
	
	private static final long serialVersionUID = -8510109087179997088L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String capName;
	//@Column(unique=true)
	private String capId;
	private String capEmail;
	private String phone;
	private String buService;
	private String project;
	private String location;
	
	protected Profile(){}
	
	public Profile(String capName, String capId, String capEmail, String phone, String buService, String project,
			String location) {
		super();
		this.capName = capName;
		this.capId = capId;
		this.capEmail = capEmail;
		this.phone = phone;
		this.buService = buService;
		this.project = project;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCapName() {
		return capName;
	}

	public void setCapName(String capName) {
		this.capName = capName;
	}

	public String getCapId() {
		return capId;
	}

	public void setCapId(String capId) {
		this.capId = capId;
	}

	public String getCapEmail() {
		return capEmail;
	}

	public void setCapEmail(String capEmail) {
		this.capEmail = capEmail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBuService() {
		return buService;
	}

	public void setBuService(String buService) {
		this.buService = buService;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", capName=" + capName + ", capId=" + capId + ", capEmail=" + capEmail + ", phone="
				+ phone + ", buService=" + buService + ", project=" + project + ", location=" + location + "]";
	}
	
}
