package myproject.loanmaintain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@EnableJpaRepositories("myproject.loanmaintain.repository")
@SpringBootApplication
@ComponentScan(basePackages = {"myproject.loanmaintain"})
public class LoanMaintainApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanMaintainApplication.class, args);
	}

}
