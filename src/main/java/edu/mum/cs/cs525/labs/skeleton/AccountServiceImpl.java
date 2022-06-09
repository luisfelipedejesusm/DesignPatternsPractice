package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.command.*;
import edu.mum.cs.cs525.labs.skeleton.factory.AccountFactory;
import edu.mum.cs.cs525.labs.skeleton.observer.*;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.SavingsStrategy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static edu.mum.cs.cs525.labs.skeleton.observer.EventType.*;

public class AccountServiceImpl implements AccountService, Subject {

	private final AccountDAO accountDAO;
	private final AccountFactory factory;
	private final List<Observer> observers = new ArrayList<>();
	private final CommandRunner commandRunner = new CommandRunnerImpl();
	
	public AccountServiceImpl(AccountFactory factory){
		this.factory = factory;
		accountDAO = factory.getAccountDAO();

		subscribe(new Mail());
		subscribe(new SmsSender());
		subscribe(new Interest());
	}

	public Account createAccount(String accountNumber, String customerName) {
		return createAccount(accountNumber, customerName, SavingsStrategy.INSTANCE);
	}

	public Account createAccount(String accountNumber, String customerName, InterestStrategy accType) {

		Account account = factory.getAccount(accountNumber, customerName, accType);

		accountDAO.saveAccount(account);
		notifyChanges(ACCOUNT_CREATED);

		return account;
	}

	public void deposit(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);

		commandRunner.runCommand(new DepositCommand(account, amount));

		accountDAO.updateAccount(account);
		notifyChanges(ACCOUNT_CHANGE);
	}

	public Account getAccount(String accountNumber) {
		return accountDAO.loadAccount(accountNumber);
	}

	public Collection<Account> getAllAccounts() {
		return accountDAO.getAccounts();
	}

	public void withdraw(String accountNumber, double amount) {
		Account account = accountDAO.loadAccount(accountNumber);

		commandRunner.runCommand(new WithdrawCommand(account, amount));

		accountDAO.updateAccount(account);
		notifyChanges(ACCOUNT_CHANGE);
	}

	public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
		Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
		Account toAccount = accountDAO.loadAccount(toAccountNumber);

		commandRunner.runCommand(new TransferFundsCommand(fromAccount, toAccount, amount, description));

		accountDAO.updateAccount(fromAccount);
		accountDAO.updateAccount(toAccount);
		notifyChanges(ACCOUNT_CHANGE);
	}

	public void undoLastCommand(){
		commandRunner.undoLastCommand();
	}

	@Override
	public void addInterest() {
		Stream<Account> accounts = getAllAccounts().stream();
		accounts.forEach(Account::addInterest);

		notifyChanges(INTEREST);
	}

	@Override
	public void subscribe(Observer o) {
		if(!observers.contains(o))
			observers.add(o);
	}

	@Override
	public void unsubscribe(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyChanges() {
		observers.forEach(observer -> observer.update(null));
	}

	@Override
	public void notifyChanges(EventType ev) {
		observers.forEach(observer -> observer.update(ev, null));
	}

}
