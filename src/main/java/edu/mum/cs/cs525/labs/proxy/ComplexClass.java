package edu.mum.cs.cs525.labs.proxy;

public class ComplexClass implements Complicated{

    public ComplexClass() throws InterruptedException {
        Thread.sleep(10000);
    }

    public void veryComplicatedTask() {
        System.out.println("Very complicated task...");
    }
}
