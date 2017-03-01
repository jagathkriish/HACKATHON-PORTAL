package com.vv.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String expenseName;
	private String expenseExplain;
	private int expenseAmount;
	private String proofFile;
	@Temporal(TemporalType.DATE)
	@Column(name = "Exp_Date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Date dateCol;
	
	protected Expense() {} 
	
	public Expense(String expenseName,String expenseExplain,int expenseAmount,String proofFile) {
		this.expenseName = expenseName;
		this.expenseExplain = expenseExplain;
		this.expenseAmount = expenseAmount;
		this.proofFile = proofFile;
	}

	public Date getDateCol() {
		return dateCol;
	}

	public void setDateCol(Date dateCol) {
		this.dateCol = dateCol;
	}

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

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

	public int getExpenseAmount() {
		return expenseAmount;
	}
	
	public void setExpenseAmount(int expenseAmount) {
		this.expenseAmount = expenseAmount;
	}
	
	public String getProofFile() {
		return proofFile;
	}

	public void setProofFile(String proofFile) {
		this.proofFile = proofFile;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", expenseName=" + expenseName + ", expenseExplain=" + expenseExplain
				+ ", expenseAmount=" + expenseAmount + ", proofFile=" + proofFile + ", dateCol=" + dateCol + "]";
	}
}
