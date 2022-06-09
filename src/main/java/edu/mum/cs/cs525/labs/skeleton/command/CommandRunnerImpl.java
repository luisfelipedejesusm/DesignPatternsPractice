package edu.mum.cs.cs525.labs.skeleton.command;

import java.util.Stack;

public class CommandRunnerImpl implements CommandRunner{

    private final Stack<Command> ranCommands = new Stack<>();

    @Override
    public void runCommand(Command command) {
        command.execute();
        ranCommands.add(command);
    }

    @Override
    public void undoLastCommand() {
        if( !ranCommands.empty() )
            ranCommands.pop().undo();
    }
}
