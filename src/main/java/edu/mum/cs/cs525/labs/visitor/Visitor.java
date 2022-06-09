package edu.mum.cs.cs525.labs.visitor;

public interface Visitor {
    void visit(Composite composite);
    void visit(Leaf leaf);
}
