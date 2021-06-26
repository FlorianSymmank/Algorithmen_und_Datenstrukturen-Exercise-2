package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.commands.ReadStudentCommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class AddAtCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public AddAtCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {

        // get valid index
        int index = -1;
        while (index < 0 || index > list.size()) {
            index = cnsl.readInteger("Enter index at which the student is to be inserted (0 - " + list.size() + "): ");
        }

        Student student = new Student();
        new ReadStudentCommand(cnsl, student).execute();
        list.add(index, student);
        cnsl.write("Added " + student.toString());
    }

    @Override
    public String toString() {
        return "Inserts the Student at the specified position in this list.";
    }
}
