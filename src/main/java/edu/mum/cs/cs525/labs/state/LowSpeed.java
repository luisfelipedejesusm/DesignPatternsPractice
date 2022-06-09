package edu.mum.cs.cs525.labs.state;

import static edu.mum.cs.cs525.labs.state.States.*;

public class LowSpeed implements FanState{
    @Override
    public FanState pullGreen() {
        return MEDIUM.getState();
    }

    @Override
    public FanState pullRed() {
        return OFF.getState();
    }

    @Override
    public String getStateName() {
        return "Low Speed";
    }
}
