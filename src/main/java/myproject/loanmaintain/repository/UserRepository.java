package myproject.loanmaintain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import myproject.loanmaintain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value="select userId from User where userName = :userName")
	public String existsByUserName(@Param("userName") String userName);
	
	@Query(value="select count(*) from User where userName = :userName and password=:password")
	public int authenticate(@Param("userName") String userName,
							@Param("password") String password);
}
