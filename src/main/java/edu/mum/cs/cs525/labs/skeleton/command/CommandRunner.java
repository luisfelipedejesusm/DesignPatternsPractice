package edu.mum.cs.cs525.labs.skeleton.command;

public interface CommandRunner {
    void runCommand(Command command);
    void undoLastCommand();
}
