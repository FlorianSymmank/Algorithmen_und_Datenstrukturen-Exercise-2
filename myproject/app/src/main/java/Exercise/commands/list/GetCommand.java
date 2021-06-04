package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class GetCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public GetCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        int index = -1;

        while (index < 0 || index > list.size()) {
            index = cnsl.readInteger("Enter index of the student to return (0 - " + list.size() + "): ");
        }

        Student student = list.get(index);
        cnsl.write("Got " + student.toString());
    }

    @Override
    public String toString() {
        return "Returns the Student at the specified position in this list.";
    }
}
