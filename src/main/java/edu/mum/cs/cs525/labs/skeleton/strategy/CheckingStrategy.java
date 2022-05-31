package edu.mum.cs.cs525.labs.skeleton.strategy;

public enum CheckingStrategy implements InterestStrategy {
    INSTANCE;

    @Override
    public double getInterest(double balance) {
        return balance * (balance < 1000? 0.015 : 0.025);
    }
}
