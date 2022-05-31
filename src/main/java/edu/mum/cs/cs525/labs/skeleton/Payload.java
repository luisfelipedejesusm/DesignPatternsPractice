package edu.mum.cs.cs525.labs.skeleton;

public class Payload<T> {
    private final T t;

    public Payload(T t){
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
