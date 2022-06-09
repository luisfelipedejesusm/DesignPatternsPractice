package edu.mum.cs.cs525.labs.state;

import static edu.mum.cs.cs525.labs.state.States.*;

public class HighSpeed implements FanState{

    @Override
    public FanState pullGreen() {
        return OFF.getState();
    }

    @Override
    public FanState pullRed() {
        return MEDIUM.getState();
    }

    @Override
    public String getStateName() {
        return "High Speed";
    }
}
