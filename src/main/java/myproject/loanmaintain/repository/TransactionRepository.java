package myproject.loanmaintain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import myproject.loanmaintain.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	@Query(value="select t from Transaction t where t.sender.userId = :sender")
	public List<Transaction> getTransactionsBySender(@Param("sender") int sender);
	
	@Query(value="select t from Transaction t where t.receiver.userId = :receiver")
	public List<Transaction> getTransactionsByReceiver(@Param("receiver") int receiver);
}
