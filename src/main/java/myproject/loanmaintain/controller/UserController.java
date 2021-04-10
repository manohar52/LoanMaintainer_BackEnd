package myproject.loanmaintain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import myproject.loanmaintain.model.User;
import myproject.loanmaintain.repository.UserRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path="/api/users")
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	@ApiOperation(value="get users")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Succesfull")
	})
	@GetMapping
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@ApiOperation(value="create new user")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Succesfull"),
			@ApiResponse(code=403,message="Username already taken")
	})
	@PostMapping
	public User registerUser(@RequestBody final User user) {
		String check = userRepo.existsByUserName(user.getUserName());
		if(check == null) {
			return userRepo.saveAndFlush(user);
		}
		else {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN,"Username already taken");
		}
	}
	
	@ApiOperation(value="authenticate user")
	@ApiResponses(value= {
			@ApiResponse(code=200,message="Succesfull"),
	})
	@PostMapping("/login")
	public boolean authenticateUser(@RequestBody final User user) {
		if(userRepo.authenticate(user.getUserName(),user.getPassword()) > 0){
			return true;
		}
		return false;
	}
	
	
}
