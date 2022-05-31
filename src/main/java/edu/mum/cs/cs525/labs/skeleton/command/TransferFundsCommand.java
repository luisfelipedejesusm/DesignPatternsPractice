package edu.mum.cs.cs525.labs.skeleton.command;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class TransferFundsCommand implements Command{

    private final Account fromAccount;
    private final Account toAccount;
    private final Double amount;
    private final String description;

    public TransferFundsCommand(Account fromAccount, Account toAccount, Double amount, String description) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.description = description;
    }

    @Override
    public void execute() {
        fromAccount.transferFunds(toAccount, amount, description);
    }

    @Override
    public void undo() {
        toAccount.transferFunds(fromAccount, amount, description + " undo");
    }
}
