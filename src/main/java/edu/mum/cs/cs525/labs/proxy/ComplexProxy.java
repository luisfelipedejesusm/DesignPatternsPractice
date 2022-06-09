package edu.mum.cs.cs525.labs.proxy;

public class ComplexProxy implements Complicated{

    private ComplexClass complexClass;

    public ComplexProxy(){
        System.out.println("Proxy Instance");
    }

    @Override
    public void veryComplicatedTask() throws InterruptedException {
        if(complexClass == null)
            complexClass = new ComplexClass();

        complexClass.veryComplicatedTask();
    }
}
