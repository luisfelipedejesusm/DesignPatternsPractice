package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountDAOImpl;
import edu.mum.cs.cs525.labs.skeleton.Customer;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;
import edu.mum.cs.cs525.labs.skeleton.strategy.SavingsStrategy;

public class ProductionFactory implements AccountFactory {
    @Override
    public AccountDAO getAccountDAO() {
        return new AccountDAOImpl();
    }

    @Override
    public Account getAccount(String accountNumber, String customerName, InterestStrategy accType) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        account.setAccountStrategy(accType);
        return account;
    }

}
