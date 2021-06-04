package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class SizeCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public SizeCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        cnsl.write("Size: " + list.size());
    }

    @Override
    public String toString() {
        return "Returns the number of Students in this list.";
    }
}
