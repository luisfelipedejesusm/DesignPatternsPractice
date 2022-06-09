package edu.mum.cs.cs525.labs.state;

public interface FanState {
    FanState pullGreen();
    FanState pullRed();
    String getStateName();
}
