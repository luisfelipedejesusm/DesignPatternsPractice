package edu.mum.cs.cs525.labs.state;

public class CeilingFan {
    
    private FanState state;

    public CeilingFan(FanState state){
        this.state = state;
    }

    public void pullGreen() {
        state = state.pullGreen();
        System.out.println("Fan is " + state.getStateName());
    }

    public void pullRed() {
        state = state.pullRed();
        System.out.println("Fan is " + state.getStateName());
    }
}
