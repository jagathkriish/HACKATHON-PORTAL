package com.vv.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

public class ExpenseFeedForm {

	@NotNull
	@Size(min=2, max=200)
	private String expenseName;
	@NotNull
	@Size(min=2, max=1000)
	private String expenseExplain;
	@NotNull(message="Enter your expense amount in numbers") @Min(1) @Max(200000)
	private Integer expenseAmount;
	@NotNull
	private MultipartFile proofFile;
	
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getExpenseExplain() {
		return expenseExplain;
	}
	public void setExpenseExplain(String expenseExplain) {
		this.expenseExplain = expenseExplain;
	}
	public Integer getExpenseAmount() {
		return expenseAmount;
	}
	public void setExpenseAmount(Integer expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	public MultipartFile getProofFile() {
		return proofFile;
	}
	public void setProofFile(MultipartFile proofFile) {
		this.proofFile = proofFile;
	}
	
	@Override
	public String toString() {
		return "ExpenseFeedForm [expenseName=" + expenseName + ", expenseExplain=" + expenseExplain + ", expenseAmount="
				+ expenseAmount + ", proofFile=" + proofFile + "]";
	}
	
}
