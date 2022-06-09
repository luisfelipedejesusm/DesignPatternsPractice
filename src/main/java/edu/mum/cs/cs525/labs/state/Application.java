package edu.mum.cs.cs525.labs.state;

public class Application {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan(States.OFF.getState());
        fan.pullGreen();
        fan.pullGreen();
        fan.pullGreen();
        fan.pullGreen();
        fan.pullRed();
        fan.pullRed();
    }
}
