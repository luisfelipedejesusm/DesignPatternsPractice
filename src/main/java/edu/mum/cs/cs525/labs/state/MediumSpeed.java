package edu.mum.cs.cs525.labs.state;

import static edu.mum.cs.cs525.labs.state.States.*;

public class MediumSpeed implements FanState {
    @Override
    public FanState pullGreen() {
        return HIGH.getState();
    }

    @Override
    public FanState pullRed() {
        return LOW.getState();
    }

    @Override
    public String getStateName() {
        return "Medium Speed";
    }
}
