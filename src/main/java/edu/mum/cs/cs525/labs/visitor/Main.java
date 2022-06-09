package edu.mum.cs.cs525.labs.visitor;

import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Lets make a tree
        Composite root = new Composite();
        Composite node1 = new Composite();
        Composite node2 = new Composite();
        Leaf leaf1 = new Leaf(5.0);
        Leaf leaf2 = new Leaf(4.0);
        Leaf leaf3 = new Leaf(3.0);
        Leaf leaf4 = new Leaf(66.0);

        root.addToList(node1);
        root.addToList(node2);

        node1.addToList(leaf1);
        node1.addToList(leaf2);
        node1.addToList(leaf4);
        node2.addToList(leaf3);

        ComponentCollector visitor = new ComponentCollector();
        root.accept(visitor);

        TotalCollector collector = new TotalCollector();
        root.accept(collector);

        System.out.println("Largest Value: " + visitor.get().getValue());
        System.out.println("Total Value: " + collector.get());
    }
}
