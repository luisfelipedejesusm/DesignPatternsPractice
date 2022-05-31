package edu.mum.cs.cs525.labs.skeleton.decorator;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public abstract class InterestDecorator implements InterestStrategy {
    private InterestStrategy strategy;

    public InterestDecorator(InterestStrategy strategy) {
        this.strategy = strategy;
    }

    public InterestStrategy getStrategy() {
        return strategy;
    }
}
