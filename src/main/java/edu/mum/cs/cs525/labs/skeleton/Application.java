package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.decorator.InterestP1;
import edu.mum.cs.cs525.labs.skeleton.factory.ProductionFactory;
import edu.mum.cs.cs525.labs.skeleton.factory.TestingFactory;
import edu.mum.cs.cs525.labs.skeleton.strategy.CheckingStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.SavingsStrategy;

public class Application {
	public static void main(String[] args) {
		AccountService accountService = new AccountServiceImpl(new ProductionFactory());

		setupCommands();

		// create 2 accounts;
		Account account1 = accountService.createAccount("1263862", "Frank Brown", CheckingStrategy.INSTANCE);
		Account account2 = accountService.createAccount("4253892", "John Doe", SavingsStrategy.INSTANCE);

		// use account 1;
		accountService.deposit("1263862", 240);
		accountService.deposit("1263862", 529);
		accountService.withdraw("1263862", 230);

		accountService.undoLastCommand();
		// use account 2;
		accountService.deposit("4253892", 12450);
		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
		// show balances

		InterestStrategy strategy = SavingsStrategy.INSTANCE;
		strategy = new InterestP1(strategy);
		strategy = new InterestP1(strategy);
		account2.setAccountStrategy(strategy);

		accountService.addInterest();

		for (Account account : accountService.getAllAccounts()) {
			Customer customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountNumber());
			System.out.println("Account Holder: " + customer.getName());
			
			System.out.println("-Date-------------------------" 
					+ "-Description------------------" 
					+ "-Amount-------------");
			
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", 
						entry.getDate().toString(), 
						entry.getDescription(),
						entry.getAmount());
			}
			
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());




		}
	}

	private static void setupCommands() {

	}

}
