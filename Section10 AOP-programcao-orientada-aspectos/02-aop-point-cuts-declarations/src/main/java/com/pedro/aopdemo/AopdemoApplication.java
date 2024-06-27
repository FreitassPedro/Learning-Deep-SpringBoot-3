package com.pedro.aopdemo;

import com.pedro.aopdemo.dao.AccountDAO;
import com.pedro.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(theAccountDAO, membershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
		Account account = new Account();
		account.setName("Pedro");
		account.setLevel("Diamond");
		theAccountDAO.addAccount(account, true);
		theAccountDAO.doWork();

		// call the accountDao getter/setter
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		theAccountDAO.getName();
		theAccountDAO.getServiceCode();

		// call membership methods
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
	}

}
