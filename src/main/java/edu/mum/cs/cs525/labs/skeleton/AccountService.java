package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.command.Command;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName);
    // Better with builder pattern
    Account createAccount(String accountNumber, String customerName, InterestStrategy accType);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);

    void addInterest();

    void undoLastCommand();
}
