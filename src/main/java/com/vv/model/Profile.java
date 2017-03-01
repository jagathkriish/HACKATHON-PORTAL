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
	@Column(unique=true)
	private String capId;
	private String ideaThonName;
	private String capEmail;
	
	protected Profile(){}
	
	public Profile(String capId, String ideaThonName, String capEmail) {
		super();
		this.capId = capId;
		this.ideaThonName = ideaThonName;
		this.capEmail = capEmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCapId() {
		return capId;
	}

	public void setCapId(String capId) {
		this.capId = capId;
	}

	public String getIdeaThonName() {
		return ideaThonName;
	}

	public void setIdeaThonName(String ideaThonName) {
		this.ideaThonName = ideaThonName;
	}

	public String getCapEmail() {
		return capEmail;
	}

	public void setCapEmail(String capEmail) {
		this.capEmail = capEmail;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", capId=" + capId + ", ideaThonName=" + ideaThonName + ", capEmail=" + capEmail
				+ "]";
	}
	
}
