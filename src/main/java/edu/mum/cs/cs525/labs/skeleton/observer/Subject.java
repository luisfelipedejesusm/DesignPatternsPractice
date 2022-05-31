package edu.mum.cs.cs525.labs.skeleton.observer;

public interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyChanges();
    void notifyChanges(EventType ev);
}
