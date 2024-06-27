package com.pedro.aopdemo;

import com.pedro.aopdemo.dao.AccountDAO;
import com.pedro.aopdemo.dao.MembershipDAO;
import com.pedro.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO membershipDAO,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
			// demoTheBeforeAdvice(theAccountDAO, membershipDAO);
			// demoAfterReturningAdvice(theAccountDAO);
				
			// demoTheAfterThrowingAdvice(theAccountDAO);
			// demoTheAfterAdvice(theAccountDAO);

			// demoTheAroundAdvice(trafficFortuneService);
			// demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune()");

		// Fique tranquilo se gerar uma mensagem imensa de exceção,
		// nosso código está programado para isto!
		boolean tripWire = true;f
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = trafficFortuneService.getFortune(tripWire);

		System.out.println("\nMy fortune is: " + data);
	}


	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("\nMain Program: demoTheAroundAdvice");
		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> accounts = null;
		try	{
			// add boolean flag to simulate exceptions
			boolean tripWire = true;

			accounts = theAccountDAO.findAccounts(tripWire);
		} catch (Exception ex) {
			System.out.println("\n\nMain Program: ...caught exception: " + ex);
		}
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
