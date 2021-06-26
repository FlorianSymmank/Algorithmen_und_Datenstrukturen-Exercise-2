package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class RemoveAtCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public RemoveAtCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {

        // get valid index
        int index = -1;
        while (index < 0 || index > list.size()) {
            index = cnsl.readInteger("Enter the index of the student to be removed (0 - " + list.size() + "): ");
        }

        list.remove(index);
        cnsl.write("Removed index: " + index);
    }

    @Override
    public String toString() {
        return "Removes the Student at the specified position in this list.";
    }
}

