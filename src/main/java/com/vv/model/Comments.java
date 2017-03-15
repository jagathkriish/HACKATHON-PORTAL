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
	private Idea idea;
	private String comment;
	private String commentedBy;
	@Column(name = "createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	
	protected Comments() {}

	public Comments(Idea idea, String comment, String commentedBy, Date createdAt) {
		super();
		this.idea = idea;
		this.comment = comment;
		this.commentedBy = commentedBy;
		this.createdAt = createdAt;
	}
	
	public Comments(Idea idea, String comment, String commentedBy) {
		super();
		this.idea = idea;
		this.comment = comment;
		this.commentedBy = commentedBy;
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
		return "Comments [id=" + id + ", idea=" + idea + ", comment=" + comment + ", commentedBy=" + commentedBy
				+ ", createdAt=" + createdAt + "]";
	}
	
}
