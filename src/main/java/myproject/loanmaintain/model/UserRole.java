package myproject.loanmaintain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "role_id")
	private int roleId;
	private String roleName;
	
	
	public UserRole() {
	}
	public UserRole(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public int getRoleId() {
		return roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	
	
}
