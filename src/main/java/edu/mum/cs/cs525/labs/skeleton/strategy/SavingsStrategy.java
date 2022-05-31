package edu.mum.cs.cs525.labs.skeleton.strategy;

public enum SavingsStrategy implements InterestStrategy {
    INSTANCE;

    @Override
    public double getInterest(double balance) {
        return balance * (balance < 1000? 0.01 : balance < 5000? 0.02 : 0.04);
    }
}
