package Exercise.commands.find;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;
import Exercise.sort.IComparator;

import java.util.function.Predicate;

public class SearchCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public SearchCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        Predicate<Student> predicate = null;
        while (predicate == null) {

            cnsl.write("Select a property to search for the student");
            cnsl.write("");
            cnsl.write("1. Search by prename?");
            cnsl.write("2. Search by surname?");
            cnsl.write("3. Search by course number?");
            cnsl.write("4. Search by matriculation number?");
            cnsl.write("");

            int option = cnsl.readInteger("Please enter a number for an option:");
            switch (option) {
                case 1:
                    String prename = cnsl.readString("Please enter prename for the search:");
                    predicate = new Predicate<Student>() {
                        @Override
                        public boolean test(Student student) {
                            return student.getPrename().equals(prename);
                        }
                    };
                    break;
                case 2:
                    String surname = cnsl.readString("Please enter surname for the search:");
                    predicate = new Predicate<Student>() {
                        @Override
                        public boolean test(Student student) {
                            return student.getSurname().equals(surname);
                        }
                    };
                    break;
                case 3:

                    // get valid course number
                    int courseNumber = -1;
                    while (!Student.Course.isValidNumber(courseNumber)){
                        courseNumber = cnsl.readInteger("Please enter course number for the search (Options: " + Student.Course.getAllOptionsString() + "):");
                    }

                    Student.Course course = Student.Course.values()[courseNumber];
                    predicate = new Predicate<Student>() {
                        @Override
                        public boolean test(Student student) {
                            return student.getCourse() == course;
                        }
                    };

                    break;
                case 4:
                    int matriculationNumber = cnsl.readInteger("Please enter matriculation number for the search:");
                    predicate = new Predicate<Student>() {
                        @Override
                        public boolean test(Student student) {
                            return student.getMatriculationNumber() == matriculationNumber;
                        }
                    };
                    break;
                default:
                    cnsl.write("Option: " + option + " not available.");
                    break;
            }
        }

        IListable<Student> filteredList = list.filter(predicate);
        cnsl.write(filteredList.toString());
    }

    @Override
    public String toString() {
        return "Search for student(s) by different characteristics.";
    }
}
