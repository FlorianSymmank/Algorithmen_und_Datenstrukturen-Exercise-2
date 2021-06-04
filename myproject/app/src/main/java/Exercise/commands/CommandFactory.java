package Exercise.commands;

import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;
import Exercise.sort.SelectionSort;

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
        commands.add(new SortCommand(cnsl, list, new SelectionSort<Student>()));
        commands.add(new ChooseSortCommand(cnsl, list));
        //TODO: Add more commands
        return commands;
    }
}
