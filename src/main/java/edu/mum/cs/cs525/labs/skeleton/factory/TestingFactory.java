package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountDAOImpl;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public class TestingFactory implements AccountFactory {
    @Override
    public AccountDAO getAccountDAO() {
        // Some other instance of AccountDAO like MockAccountDAO
        return null;
    }

    @Override
    public Account getAccount(String accountNumber, String customerName, InterestStrategy accType) {
        return null;
    }
}
