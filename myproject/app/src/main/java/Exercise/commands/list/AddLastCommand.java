package Exercise.commands.list;

import Exercise.commands.ICommand;
import Exercise.commands.ReadStudentCommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class AddLastCommand implements ICommand {
    private IConsole cnsl;
    private IListable<Student> list;

    public AddLastCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        Student student = new Student();
        new ReadStudentCommand(cnsl, student).execute();
        list.addLast(student);
        cnsl.write("Added " + student.toString());
    }

    @Override
    public String toString() {
        return "Appends the Student to the end of this list.";
    }
}