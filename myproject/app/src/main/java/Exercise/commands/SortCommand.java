package Exercise.commands;

import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;
import Exercise.sort.IComparator;
import Exercise.sort.ISortable;

import java.lang.reflect.Field;

public class SortCommand implements ICommand {
    private final IConsole cnsl;
    private final IListable<Student> list;
    private final ISortable<Student> sort;

    public SortCommand(IConsole cnsl, IListable<Student> list, ISortable<Student> sort) {
        this.cnsl = cnsl;
        this.list = list;
        this.sort = sort;
    }

    @Override
    public void execute() {
// Get all fields in type of type IComparator via reflection
//        try {
//            for (Field field : Student.class.getDeclaredFields())
//                if (field.getType() == IComparator.class)
//                    System.out.println(((IComparator) field.get(null)).toString());
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        IComparator<Student> comp = null;
        while (comp == null) {

            cnsl.write("Please select a property for sorting with the '" + sort.getClass().getSimpleName() + "' algorithm:");
            cnsl.write("");
            cnsl.write("1. Sort by course");
            cnsl.write("2. Sort by matriculation number");
            cnsl.write("3. Sort by surname");
            cnsl.write("4. Sort by prename");
            cnsl.write("");

            int option = cnsl.readInteger("Please enter a number for an option:");
            switch (option){
                case 1:
                    comp = Student.CourseComparator;
                    break;
                case 2:
                    comp = Student.MatriculationNumberComparator;
                    break;
                case 3:
                    comp = Student.SurnameComparator;
                    break;
                case 4:
                    comp = Student.PrenameComparator;
                    break;
                default:
                    cnsl.write("Option: " + option + " not available.");
                    break;
            }
        }

        sort.sort(list, comp);
        cnsl.write(list.toString());
    }

    @Override
    public String toString() {
        return "Choose property to sort by";
    }
}
