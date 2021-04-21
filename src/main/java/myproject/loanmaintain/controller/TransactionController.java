package myproject.loanmaintain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import myproject.loanmaintain.model.Transaction;
import myproject.loanmaintain.repository.TransactionRepository;
import myproject.loanmaintain.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionRepository transactionRepo;
	@Autowired
	private UserRepository userRepo;
	
	@ApiOperation(value="get transaction by sender's username")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Succesfull")
	})
	@GetMapping("/sender/{sender}")
	public List<Transaction> getTransactionsBySender(@PathVariable(value="sender") String sender){
		int id = userRepo.getUserByUsername(sender);
		return transactionRepo.getTransactionsBySender(id);
	}

	@ApiOperation(value="get transaction by receiver's username")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Succesfull")
	})
	@GetMapping("/receiver/{receiver}")
	public List<Transaction> getTransactionsByReceiver(@PathVariable(value="sender") String receiver){
		int id = userRepo.getUserByUsername(receiver);
		return transactionRepo.getTransactionsByReceiver(id);
	}
	@Autowired
	private TransactionRepository transactionRepository;
	
	@ApiOperation(value="add new transaction")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Successfull"),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=404,message="Not found"),
			@ApiResponse(code=500,message="Internal Server error"),
	})
	@PostMapping
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
		return ResponseEntity.ok(transactionRepository.saveAndFlush(transaction));
	}	
}
