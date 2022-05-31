package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class SmsSender implements Observer{

    @Override
    public void update(EventType ev, Object payload) {
        if (ev == EventType.ACCOUNT_CHANGE)
            System.out.println("SMS for account change");
    }

    @Override
    public void update(Object payload) {
        System.out.println("SMS sent!");
    }
}
