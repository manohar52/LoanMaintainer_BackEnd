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
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@OneToOne
	@JsonProperty("sender")
	@JoinColumn(name="sender", referencedColumnName = "userId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User sender;
	
	@OneToOne
	@JoinColumn(name="receiver", referencedColumnName = "userId")
	@JsonProperty("receiver")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User receiver;
	
	private String currency;
	private double amount;
	private Date timestamp;
	
	@OneToOne
	@JoinColumn(name="status_id",referencedColumnName = "statusId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("status")
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
	public User getSender() {
		return sender;
	}
	public User getReceiver() {
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
