package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class RemoveAllCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public RemoveAllCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        list.clear();
        cnsl.write("Cleared all students from list.");
    }

    @Override
    public String toString() {
        return "Removes all of the Students from this list.";
    }
}
