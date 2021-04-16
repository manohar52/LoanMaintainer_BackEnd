package myproject.loanmaintain.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "userId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User senderUser;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "userId")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private User receiverUser;
	
	private String currency;
	private Long amount;
	private Date tms;
	
	@OneToOne
	@JoinColumn(referencedColumnName = "status_id")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Status status;
	
}
