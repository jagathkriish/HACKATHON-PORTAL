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
	private String itype;
	@Column(length=1000)
	private String problem;
	private String industry;
	private String areaOfFunc;
	private String technology;
	@Column(length=100)
	private String solnTitle;
	@Column(length=10000)
	private String solnDesc;
	@Column(length=1000)
	private String buBenefit;
	private String buInvest;
	private String buIncome;
	private String documentName;
	private String videoName;
	private String status;
	private float rating;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdAt;
	
	protected Idea() {}

	public Idea(Profile profile, String itype, String problem, String industry, String areaOfFunc, String technology,
			String solnTitle, String solnDesc, String buBenefit, String buInvest, String buIncome, String documentName,
			String videoName, String status, float rating) {
		super();
		this.profile = profile;
		this.itype = itype;
		this.problem = problem;
		this.industry = industry;
		this.areaOfFunc = areaOfFunc;
		this.technology = technology;
		this.solnTitle = solnTitle;
		this.solnDesc = solnDesc;
		this.buBenefit = buBenefit;
		this.buInvest = buInvest;
		this.buIncome = buIncome;
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

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getAreaOfFunc() {
		return areaOfFunc;
	}

	public void setAreaOfFunc(String areaOfFunc) {
		this.areaOfFunc = areaOfFunc;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getSolnTitle() {
		return solnTitle;
	}

	public void setSolnTitle(String solnTitle) {
		this.solnTitle = solnTitle;
	}

	public String getSolnDesc() {
		return solnDesc;
	}

	public void setSolnDesc(String solnDesc) {
		this.solnDesc = solnDesc;
	}

	public String getBuBenefit() {
		return buBenefit;
	}

	public void setBuBenefit(String buBenefit) {
		this.buBenefit = buBenefit;
	}

	public String getBuInvest() {
		return buInvest;
	}

	public void setBuInvest(String buInvest) {
		this.buInvest = buInvest;
	}

	public String getBuIncome() {
		return buIncome;
	}

	public void setBuIncome(String buIncome) {
		this.buIncome = buIncome;
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
		return "Idea [id=" + id + ", profile=" + profile + ", itype=" + itype + ", problem=" + problem + ", industry="
				+ industry + ", areaOfFunc=" + areaOfFunc + ", technology=" + technology + ", solnTitle=" + solnTitle
				+ ", solnDesc=" + solnDesc + ", buBenefit=" + buBenefit + ", buInvest=" + buInvest + ", buIncome="
				+ buIncome + ", documentName=" + documentName + ", videoName=" + videoName + ", status=" + status
				+ ", rating=" + rating + ", createdAt=" + createdAt + "]";
	}
	
}