package edu.mum.cs.cs525.labs.proxy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Complicated complicatedClass = new ComplexProxy();
        complicatedClass.veryComplicatedTask();
    }
}
