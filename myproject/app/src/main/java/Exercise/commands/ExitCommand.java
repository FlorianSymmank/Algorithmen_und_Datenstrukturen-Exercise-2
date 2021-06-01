package Exercise.commands;

import Exercise.console.IConsole;

public class ExitCommand implements ICommand {
    private IConsole cnsl;

    public ExitCommand(IConsole cnsl) {
        this.cnsl = cnsl;
    }

    @Override
    public void execute() {
        cnsl.write("Ciao!");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "Exit.";
    }
}