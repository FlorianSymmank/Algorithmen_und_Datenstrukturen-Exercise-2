package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.commands.ReadStudentCommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class AddCommand implements ICommand {
    private final IConsole cnsl;
    private final IListable<Student> list;

    public AddCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        Student student = new Student();
        new ReadStudentCommand(cnsl, student).execute();
        list.add(student);
        cnsl.write("Added " + student.toString());
    }

    @Override
    public String toString() {
        return "Add Student to the end of this list.";
    }
}
