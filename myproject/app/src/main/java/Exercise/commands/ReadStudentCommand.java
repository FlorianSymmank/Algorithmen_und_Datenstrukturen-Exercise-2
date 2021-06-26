package Exercise.commands;

import Exercise.console.IConsole;
import Exercise.data.Student;

public class ReadStudentCommand implements ICommand {

    private final IConsole cnsl;
    private Student student;

    public ReadStudentCommand(IConsole cnsl, Student student) {
        this.cnsl = cnsl;
        this.student = student;
    }

    @Override
    public void execute() {
        student.setPrename(cnsl.readString("Please enter prename:"));
        student.setSurname(cnsl.readString("Please enter surname:"));

        // get valid course number
        int courseNumber = -1;
        while (!Student.Course.isValidNumber(courseNumber)) {
            courseNumber = cnsl.readInteger("Please enter course number (Options: " + Student.Course.getAllOptionsString() + "):");
        }
        student.setCourse(Student.Course.values()[courseNumber]);

        student.setMatriculationNumber(cnsl.readInteger("Please enter matriculation number:"));
    }
}
