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
		return "IdeaValidator [capId=" + capId + ", ideaThonName=" + ideaThonName + ", capEmail=" + capEmail
				+ ", ideaThesis=" + ideaThesis + ", docFile=" + docFile + ", videoFile=" + videoFile + "]";
	}
	
}
