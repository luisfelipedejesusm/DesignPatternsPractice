package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public interface AccountFactory {
    AccountDAO getAccountDAO();

    Account getAccount(String accountNumber, String customerName, InterestStrategy accType);
}
