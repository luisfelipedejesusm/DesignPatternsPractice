package edu.mum.cs.cs525.labs.skeleton.observer;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountService;

public class Interest implements Observer{

    @Override
    public void update(EventType ev, Object payload) {
        if (ev == EventType.INTEREST)
            System.out.println("Added some interest");
    }

    @Override
    public void update(Object payload) {

    }
}
