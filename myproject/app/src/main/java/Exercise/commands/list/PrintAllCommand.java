package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.lists.IListable;

public class PrintAllCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable list;

    public PrintAllCommand(IConsole cnsl, IListable list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        cnsl.write(list.toString());
    }

    @Override
    public String toString() {
        return "Print all students to console from list.";
    }
}
