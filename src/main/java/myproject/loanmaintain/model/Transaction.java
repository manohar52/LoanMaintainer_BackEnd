package myproject.loanmaintain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "userId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User sender;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "userId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User receiver;
	
	private String currency;
	private double amount;
	private Date timestamp;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "statusId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Status status;
	
	public Transaction(Long transactionId, User sender, User receiver, String currency, Long amount, Date tms,
			Status status) {
		this.transactionId = transactionId;
		this.sender = sender;
		this.receiver = receiver;
		this.currency = currency;
		this.amount = amount;
		this.timestamp = tms;
		this.status = status;
	}
	public Transaction() {
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public User getSenderUser() {
		return sender;
	}
	public User getReceiverUser() {
		return receiver;
	}
	public String getCurrency() {
		return currency;
	}
	public double getAmount() {
		return amount;
	}
	public Date getTms() {
		return timestamp;
	}
	public Status getStatus() {
		return status;
	}
}
