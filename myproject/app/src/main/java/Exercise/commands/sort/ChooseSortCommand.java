package Exercise.commands.sort;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;
import Exercise.sort.HeapSort;
import Exercise.sort.ISortable;
import Exercise.sort.SelectionSort;

public class ChooseSortCommand implements ICommand {

    private final IConsole cnsl;
    private final IListable<Student> list;

    public ChooseSortCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        ISortable<Student> sort = null;
        while (sort == null) {

            cnsl.write("Select a sorting method for sorting:");
            cnsl.write("");
            cnsl.write("1. Selectionsort");
            cnsl.write("2. Heapsort");

            cnsl.write("");

            int option = cnsl.readInteger("Please enter a number for an option:");
            switch (option){
                case 1:
                    sort = new SelectionSort<Student>();
                    break;
                case 2:
                    sort = new HeapSort<Student>();
                    break;
                default:
                    cnsl.write("Option: " + option + " not available.");
                    break;
            }
        }

        new SortCommand(cnsl, list, sort).execute();
    }

    @Override
    public String toString() {
        return "Sort list by different properties.";
    }
}
