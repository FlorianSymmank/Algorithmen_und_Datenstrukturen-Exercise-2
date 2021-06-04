package Exercise.commands;

import Exercise.commands.find.SearchCommand;
import Exercise.commands.list.*;
import Exercise.commands.sort.ChooseSortCommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

import java.util.LinkedList;

public class CommandFactory {
    private IConsole cnsl;
    private IListable<Student> list;

    public CommandFactory(IConsole cnsl, IListable<Student> list) {
        this.list = list;
        this.cnsl = cnsl;
    }

    public LinkedList<ICommand> returnCommands() {
        LinkedList<ICommand> commands = new LinkedList<ICommand>();

        commands.add(new ExitCommand(cnsl));

        commands.add(new AddCommand(cnsl, list));
        commands.add(new AddAtCommand(cnsl, list));
        commands.add(new AddFirstCommand(cnsl, list));
        commands.add(new AddLastCommand(cnsl, list));
        commands.add(new GetCommand(cnsl, list));
        commands.add(new PrintAllCommand(cnsl, list));
        commands.add(new SizeCommand(cnsl, list));
        commands.add(new RemoveAtCommand(cnsl, list));
        commands.add(new RemoveAllCommand(cnsl, list));

        commands.add(new SearchCommand(cnsl, list));

        commands.add(new ChooseSortCommand(cnsl, list));

        return commands;
    }
}
