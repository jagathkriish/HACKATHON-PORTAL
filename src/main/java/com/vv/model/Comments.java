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

@Entity
public class Comments implements Serializable{
	
	private static final long serialVersionUID = 6220079334277233792L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade = {CascadeType.ALL})
	private Profile profile;
	private String comment;
	private String commentedBy;
	@Column(name = "createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	
	protected Comments() {}

	public Comments(Profile profile, String comment, String commentedBy, Date createdAt) {
		super();
		this.profile = profile;
		this.comment = comment;
		this.commentedBy = commentedBy;
		this.createdAt = createdAt;
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", profile=" + profile + ", comment=" + comment + ", commentedBy=" + commentedBy
				+ ", createdAt=" + createdAt + "]";
	}

}
