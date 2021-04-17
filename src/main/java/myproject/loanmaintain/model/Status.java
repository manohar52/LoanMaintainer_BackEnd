package myproject.loanmaintain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long statusId;
	private String description;

	public long getStatusId() {
		return statusId;
	}
	public String getDescription() {
		return description;
	}
	public Status(long statusId, String description) {
		this.statusId = statusId;
		this.description = description;
	}
	public Status() {
	}	
}
