package com.pedro.aopdemo;

import com.pedro.aopdemo.dao.AccountDAO;
import com.pedro.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, membershipDAO);
			// demoAfterReturningAdvice(theAccountDAO);
				
			demoTheAfterThrowingAdvice(theAccountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
		List<Account> accounts = null;
		try	{
			// add boolean flag to simulate exceptions
			boolean tripWire = true;

			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception ex) {
			System.out.println("\n\nMain Program: ...caught exception: " + ex);
		}
	}

	private void demoAfterReturningAdvice(AccountDAO theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		System.out.println("\n\nMain Program: demoTheAfterReturningAdvice");
		System.out.println(theAccounts);

		System.out.println("\n---");
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
