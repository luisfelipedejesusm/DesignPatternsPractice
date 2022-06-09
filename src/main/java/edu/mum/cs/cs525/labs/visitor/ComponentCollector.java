package edu.mum.cs.cs525.labs.visitor;

import java.util.function.Supplier;

public class ComponentCollector implements Visitor, Supplier<Component> {
    private Component largest = new Leaf(Double.MIN_VALUE);

    @Override
    public void visit(Composite composite) {

    }

    @Override
    public void visit(Leaf leaf) {
        if (largest.getValue() < leaf.getValue())
            largest = leaf;
    }

    @Override
    public Component get() {
        return largest;
    }
}
