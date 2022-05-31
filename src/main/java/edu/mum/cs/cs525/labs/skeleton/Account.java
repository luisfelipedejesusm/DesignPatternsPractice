package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static edu.mum.cs.cs525.labs.skeleton.observer.EventType.*;

public class Account {

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	private InterestStrategy accountStrategy;

	private Customer customer;

	private String accountNumber;

	public Account(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public List<AccountEntry> getEntryList() {
		return entryList;
	}


	public void addInterest(){
		double interest = accountStrategy.getInterest(getBalance());
		AccountEntry entry = new AccountEntry(-interest, "interest", "", "");
		getEntryList().add(entry);
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountStrategy(InterestStrategy accountStrategy) {
		this.accountStrategy = accountStrategy;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		getEntryList().add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		getEntryList().add(entry);
	}

	private void addEntry(AccountEntry entry) {
		getEntryList().add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());

		getEntryList().add(fromEntry);
		toAccount.addEntry(toEntry);


	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
