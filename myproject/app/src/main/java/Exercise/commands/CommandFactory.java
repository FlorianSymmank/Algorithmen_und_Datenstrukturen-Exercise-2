package Exercise.commands;

import Exercise.console.IConsole;

import java.util.LinkedList;

public class CommandFactory {
    private IConsole cnsl;

    public CommandFactory(IConsole cnsl) {
        this.cnsl = cnsl;
    }

    public LinkedList<ICommand> returnCommands() {
        LinkedList<ICommand> commands = new LinkedList<ICommand>();

        return commands;
    }
}
