package edu.mum.cs.cs525.labs.skeleton.decorator;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public class InterestP1 extends InterestDecorator{

    public InterestP1(InterestStrategy strategy) {
        super(strategy);
    }

    @Override
    public double getInterest(double balance) {
        return super.getStrategy().getInterest(balance) + balance * 0.01;
    }
}
