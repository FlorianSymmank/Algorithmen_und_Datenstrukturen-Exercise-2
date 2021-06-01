package Exercise.commands;

import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class AddCommand implements ICommand {
    private IConsole cnsl;
    private IListable<Student> list;

    public AddCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {

        String prename = cnsl.readString("Please enter prename:");
        String surname = cnsl.readString("Please enter surname:");
        int course = cnsl.readInteger("Please enter course number:");
        int matrictulationNumber = cnsl.readInteger("Please enter matriculation number:");

        Student s = new Student(prename, surname, course, matrictulationNumber);
        list.add(s);
        cnsl.write("Added " + s.toString());
    }

    @Override
    public String toString() {
        //TODO: Add Text description
        return "";
    }
}