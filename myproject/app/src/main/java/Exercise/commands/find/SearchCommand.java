package Exercise.commands.find;

import Exercise.commands.ICommand;
import Exercise.console.IConsole;
import Exercise.data.Student;
import Exercise.lists.IListable;

public class SearchCommand implements ICommand {


    private final IConsole cnsl;
    private final IListable<Student> list;

    public SearchCommand(IConsole cnsl, IListable<Student> list) {
        this.cnsl = cnsl;
        this.list = list;
    }

    @Override
    public void execute() {
        // TODO: Implement seach all
        cnsl.write("TODO: Implement  seach all");
    }

    @Override
    public String toString() {
        return "Search for student(s) by different characteristics.";
    }
}
