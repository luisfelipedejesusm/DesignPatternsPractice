package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.Account;

public class Mail implements Observer{

    @Override
    public void update(EventType ev, Object payload) {
        if (ev == EventType.ACCOUNT_CREATED)
            System.out.println("Mail for account created");
    }

    @Override
    public void update(Object payload) {
        System.out.println("Mail is sent!");
    }
}
