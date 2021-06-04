package Exercise.commands;

import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;
import Exercise.sort.IComparator;
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
            // TODO: add sort algos
            cnsl.write("");

            int option = cnsl.readInteger("Please enter a number for an option:");
            switch (option){
                case 1:
                    sort = new SelectionSort<Student>();
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
