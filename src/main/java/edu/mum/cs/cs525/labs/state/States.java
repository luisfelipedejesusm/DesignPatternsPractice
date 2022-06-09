package edu.mum.cs.cs525.labs.state;

public enum States {
    OFF(new OffSpeed()),
    LOW(new LowSpeed()),
    MEDIUM(new MediumSpeed()),
    HIGH(new HighSpeed());

    private FanState state;

    States(FanState state){
        this.state = state;
    }

    public FanState getState() {
        return state;
    }
}
