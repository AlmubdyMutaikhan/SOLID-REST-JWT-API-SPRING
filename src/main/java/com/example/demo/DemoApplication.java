package com.example.demo;

import com.example.demo.classes.Account;
import com.example.demo.cli.*;
import com.example.demo.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		boolean running = true;
		String clientID = "1";

		MyCLI myCLI = context.getBean(MyCLI.class);
		AccountBasicCLI accountBasicCLI = context.getBean(AccountBasicCLI.class);
		TransactionDepositCLI transactionDepositCLI = context.getBean(TransactionDepositCLI.class);
		TransactionWithdrawCLI transactionWithdrawCLI = context.getBean(TransactionWithdrawCLI.class);
		TransactionBasicCLI transactionBasicCLI = context.getBean(TransactionBasicCLI.class);
		String helpMessage = "1 - show accounts\n2 - create account\n3 - deposit\n4 - withdraw\n5 - public void showAllTransactions()r\n6 - this message\n7 - exit\n";
		System.out.printf("Welcome to CLI bank service\n");
		System.out.printf("Enter operation number: \n");
		System.out.printf(helpMessage);
		while(running){
			switch(myCLI.getScanner().nextLine()){

				case "1":
					//accountBasicCLI.getAccounts(clientID);
					Account a = accountRepository.findClientAccount("001000001", clientID);
				//	System.out.println(a);
					for(var i : accountRepository.findAccountsByClientIDAndAccountType(clientID, "SAVING")){
						System.out.println(i);
					}
					break;

				case "2":
					accountBasicCLI.createAccountRequest(clientID);
					break;

				case "3":
					transactionDepositCLI.depositMoney(clientID);
					break;

				case "4":
					transactionWithdrawCLI.withdrawMoney(clientID);
					break;
				case "5":
					transactionBasicCLI.showAllTransactions();
					break;
				case "6":
					System.out.printf(helpMessage);
					break;

				case "7":
					System.out.printf("Application Closed\n");
					running = false;
					break;

				default:
					System.out.printf("Command not recognized!\n");
					break;
			}
		}
		myCLI.getScanner().close();
	}
}
