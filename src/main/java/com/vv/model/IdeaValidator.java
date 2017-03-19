package com.vv.model;

import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.multipart.MultipartFile;

public class IdeaValidator {
	@NotNull
	@Size(min=2, max=200)
	private String name;
	@NotNull
	@Size(min=2, max=200)
	private String capId;
	@NotNull
	@Email
	private String capEmail;
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
	private String ideaType;
	@NotNull
	@Size(min=2, max=200)
	private String problemArea;
	@NotNull
	@Size(min=1, max=200)
	private String[] industry;
	//@Size(min=2, max=200)
	private String oIndustry;
	@NotNull
	@Size(min=1, max=200)
	private String[] funcArea;
	//@Size(min=2, max=200)
	private String oFuncArea;
	@NotNull
	@Size(min=2, max=200)
	private String technology;
	@NotNull
	@Size(min=2, max=200)
	private String solnTitle;
	@NotNull
	@Size(min=5, max=10000)
	private String solnDesc;
	@NotNull
	@Size(min=2, max=200)
	private String buBenift;
	@NotNull
	@Size(min=2, max=20)
	private String buinvest;
	@NotNull
	@Size(min=2, max=20)
	private String buincome;
	@NotNull
	private MultipartFile docFile;
	private MultipartFile videoFile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getIdeaType() {
		return ideaType;
	}
	public void setIdeaType(String ideaType) {
		this.ideaType = ideaType;
	}
	public String getProblemArea() {
		return problemArea;
	}
	public void setProblemArea(String problemArea) {
		this.problemArea = problemArea;
	}
	public String[] getIndustry() {
		return industry;
	}
	public void setIndustry(String[] industry) {
		this.industry = industry;
	}
	public String getoIndustry() {
		return oIndustry;
	}
	public void setoIndustry(String oIndustry) {
		this.oIndustry = oIndustry;
	}
	public String[] getFuncArea() {
		return funcArea;
	}
	public void setFuncArea(String[] funcArea) {
		this.funcArea = funcArea;
	}
	public String getoFuncArea() {
		return oFuncArea;
	}
	public void setoFuncArea(String oFuncArea) {
		this.oFuncArea = oFuncArea;
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
	public String getBuBenift() {
		return buBenift;
	}
	public void setBuBenift(String buBenift) {
		this.buBenift = buBenift;
	}
	public String getBuinvest() {
		return buinvest;
	}
	public void setBuinvest(String buinvest) {
		this.buinvest = buinvest;
	}
	public String getBuincome() {
		return buincome;
	}
	public void setBuincome(String buincome) {
		this.buincome = buincome;
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
	@Override
	public String toString() {
		return "IdeaValidator [name=" + name + ", capId=" + capId + ", capEmail=" + capEmail + ", servicebu="
				+ servicebu + ", projectName=" + projectName + ", contactNum=" + contactNum + ", locationName="
				+ locationName + ", ideaType=" + ideaType + ", problemArea=" + problemArea + ", industry="
				+ Arrays.toString(industry) + ", oIndustry=" + oIndustry + ", funcArea=" + Arrays.toString(funcArea)
				+ ", oFuncArea=" + oFuncArea + ", technology=" + technology + ", solnTitle=" + solnTitle + ", solnDesc="
				+ solnDesc + ", buBenift=" + buBenift + ", buinvest=" + buinvest + ", buincome=" + buincome
				+ ", docFile=" + docFile + ", videoFile=" + videoFile + "]";
	}
	
}
