package com.vv.model;

import java.io.Serializable;

public class RateIdeaModel implements Serializable {

	private static final long serialVersionUID = 902969660597260490L;
	private String capId;
	private String rating;
	private String status;
	
	public String getCapId() {
		return capId;
	}
	public void setCapId(String capId) {
		this.capId = capId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
