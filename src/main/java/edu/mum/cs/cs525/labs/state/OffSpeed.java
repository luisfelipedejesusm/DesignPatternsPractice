package edu.mum.cs.cs525.labs.state;

import static edu.mum.cs.cs525.labs.state.States.*;

public class OffSpeed implements FanState{
    @Override
    public FanState pullGreen() {
        return LOW.getState();
    }

    @Override
    public FanState pullRed() {
        return HIGH.getState();
    }

    @Override
    public String getStateName() {
        return "Off";
    }
}
