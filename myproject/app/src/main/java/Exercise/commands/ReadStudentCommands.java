package Exercise.commands;

import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class ReadStudentCommands implements ICommand {

    private final IConsole cnsl;
    private Student student;

    public ReadStudentCommands(IConsole cnsl, Student student) {
        this.cnsl = cnsl;
        this.student = student;
    }

    @Override
    public void execute() {
        student.setPrename(cnsl.readString("Please enter prename:"));
        student.setSurname(cnsl.readString("Please enter surname:"));
        student.setCourse(cnsl.readInteger("Please enter course number:"));
        student.setMatriculationNumber(cnsl.readInteger("Please enter matriculation number:"));
    }
}
