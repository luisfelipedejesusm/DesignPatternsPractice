package edu.mum.cs.cs525.labs.visitor;

import java.util.function.Supplier;

public class TotalCollector implements Visitor, Supplier<Double> {
    private Double total = 0.0;

    @Override
    public void visit(Composite composite) {

    }

    @Override
    public void visit(Leaf leaf) {
        total += leaf.getValue();
    }

    @Override
    public Double get() {
        return total;
    }
}
