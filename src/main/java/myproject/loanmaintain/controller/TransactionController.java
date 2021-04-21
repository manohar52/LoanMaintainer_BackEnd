package myproject.loanmaintain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import myproject.loanmaintain.model.Transaction;
import myproject.loanmaintain.repository.TransactionRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/transactions")
public class TransactionController {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@ApiOperation(value="add new transaction")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Successfull"),
			@ApiResponse(code=400,message="Bad Request"),
			@ApiResponse(code=404,message="Not found"),
			@ApiResponse(code=500,message="Internal Server error"),
	})
	@PostMapping("/addNew")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction transaction) {
		System.out.println("Inside add Transaction");
		return ResponseEntity.ok(transactionRepository.saveAndFlush(transaction));
	}	
}
