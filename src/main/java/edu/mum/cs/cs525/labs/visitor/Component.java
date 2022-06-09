package edu.mum.cs.cs525.labs.visitor;

import java.util.function.Consumer;

public abstract class Component implements Consumer<Visitor> {
    private Double value;

    public Component(Double value) {
        this.value = value;
    }

    public final Double getValue(){
        return value;
    }
}
