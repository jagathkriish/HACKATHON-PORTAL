package com.vv.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contributions implements Serializable {

	private static final long serialVersionUID = 6899935896746259771L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Idea idea;
	private String teamName;
	private byte timeline;
	private String contribName;
	private String email;
	private String technologies;
	private String role;
	private char contribType;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	
	protected Contributions() {}
	public Contributions(Idea idea, String teamName, byte timeline, String contribName, String email,
			String technologies, String role, char contribType) {
		super();
		this.idea = idea;
		this.teamName = teamName;
		this.timeline = timeline;
		this.contribName = contribName;
		this.email = email;
		this.technologies = technologies;
		this.role = role;
		this.contribType = contribType;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Idea getIdea() {
		return idea;
	}
	public void setIdea(Idea idea) {
		this.idea = idea;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public byte getTimeline() {
		return timeline;
	}
	public void setTimeline(byte timeline) {
		this.timeline = timeline;
	}
	public String getContribName() {
		return contribName;
	}
	public void setContribName(String contribName) {
		this.contribName = contribName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTechnologies() {
		return technologies;
	}
	public void setTechnologies(String technologies) {
		this.technologies = technologies;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public char getContribType() {
		return contribType;
	}
	public void setContribType(char contribType) {
		this.contribType = contribType;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	@Override
	public String toString() {
		return "IdeaContribute [id=" + id + ", idea=" + idea + ", teamName=" + teamName + ", timeline=" + timeline
				+ ", contribName=" + contribName + ", email=" + email + ", technologies=" + technologies + ", role="
				+ role + ", contribType=" + contribType + ", createdAt=" + createdAt + "]";
	}
	
}
