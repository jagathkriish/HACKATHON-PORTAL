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
public class Idea implements Serializable{
	private static final long serialVersionUID = 7512731409528332094L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Profile profile;
	@Column(length=10000)
	private String ideaThesis;
	private String documentName;
	private String videoName;
	private String status;
	private float rating;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	
	protected Idea() {}

	public Idea(Profile profile, String ideaThesis, String documentName, String videoName, String status, int rating) {
		super();
		this.profile = profile;
		this.ideaThesis = ideaThesis;
		this.documentName = documentName;
		this.videoName = videoName;
		this.status = status;
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getIdeaThesis() {
		return ideaThesis;
	}

	public void setIdeaThesis(String ideaThesis) {
		this.ideaThesis = ideaThesis;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", profile=" + profile + ", ideaThesis=" + ideaThesis + ", documentName="
				+ documentName + ", videoName=" + videoName + ", status=" + status + ", rating=" + rating
				+ ", createdAt=" + createdAt + "]";
	}
	
}