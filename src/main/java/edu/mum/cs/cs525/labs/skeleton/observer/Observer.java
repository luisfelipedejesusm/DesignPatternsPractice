package edu.mum.cs.cs525.labs.skeleton.observer;

public interface Observer {
    void update(EventType ev, Object payload);
    void update(Object payload);
}