package com.vv.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

public class IdeaValidator {
	@NotNull
	@Size(min=2, max=200)
	private String capId;
	@NotNull
	@Size(min=2, max=200)
	private String ideaThonName;
	@NotNull
	@Email
	private String capEmail;
	@NotNull
	@Size(min=5, max=10000)
	private String ideaThesis;
	@NotNull
	private MultipartFile docFile;
	private MultipartFile videoFile;
	@NotNull
	@Size(min=2, max=200)
	private String servicebu;
	@NotNull
	@Size(min=2, max=200)
	private String projectName;
	@NotNull
	@Size(min=2, max=200)
	private String contactNum;
	@NotNull
	@Size(min=2, max=200)
	private String locationName;
	@NotNull
	@Size(min=2, max=200)
	private String problemArea;
	@NotNull
	@Size(min=1, max=200)
	private String[] vertIndus;
	@Size(min=2, max=200)
	private String oVertical;
	@NotNull
	@Size(min=1, max=200)
	private String[] farea;
	@Size(min=2, max=200)
	private String ofrea;
	@NotNull
	@Size(min=2, max=200)
	private String solTit;
	@NotNull
	@Size(min=2, max=200)
	private String sDesc;
	@NotNull
	@Size(min=2, max=200)
	private String technol;
	@NotNull
	@Size(min=2, max=200)
	private String bubenift;
	
	
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
	public String getIdeaThesis() {
		return ideaThesis;
	}
	public void setIdeaThesis(String ideaThesis) {
		this.ideaThesis = ideaThesis;
	}
	public String getServicebu() {
		return servicebu;
	}
	public void setServicebu(String servicebu) {
		this.servicebu = servicebu;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public String getProblemArea() {
		return problemArea;
	}
	public void setProblemArea(String problemArea) {
		this.problemArea = problemArea;
	}
	public String[] getVertIndus() {
		return vertIndus;
	}
	public void setVertIndus(String[] vertIndus) {
		this.vertIndus = vertIndus;
		System.out.println("LENGHT --> "+vertIndus.length);
	}
	public String[] getFarea() {
		return farea;
	}
	public void setFarea(String[] farea) {
		this.farea = farea;
	}
	public String getSolTit() {
		return solTit;
	}
	public void setSolTit(String solTit) {
		this.solTit = solTit;
	}
	public String getsDesc() {
		return sDesc;
	}
	public void setsDesc(String sDesc) {
		this.sDesc = sDesc;
	}
	public String getTechnol() {
		return technol;
	}
	public void setTechnol(String technol) {
		this.technol = technol;
	}
	public String getBubenift() {
		return bubenift;
	}
	public void setBubenift(String bubenift) {
		this.bubenift = bubenift;
	}
	public MultipartFile getDocFile() {
		return docFile;
	}
	public void setDocFile(MultipartFile docFile) {
		this.docFile = docFile;
	}
	public MultipartFile getVideoFile() {
		return videoFile;
	}
	public void setVideoFile(MultipartFile videoFile) {
		this.videoFile = videoFile;
	}
	public String getoVertical() {
		return oVertical;
	}
	public void setoVertical(String oVertical) {
		this.oVertical = oVertical;
	}
	public String getOfrea() {
		return ofrea;
	}
	public void setOfrea(String ofrea) {
		this.ofrea = ofrea;
	}
	@Override
	public String toString() {
		return "IdeaValidator [capId=" + capId + ", ideaThonName=" + ideaThonName + ", capEmail=" + capEmail
				+ ", ideaThesis=" + ideaThesis + ", docFile=" + docFile + ", videoFile=" + videoFile + "]";
	}
	
}
