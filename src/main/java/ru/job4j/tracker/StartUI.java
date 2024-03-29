package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartUI {
    private Output out;
    private static List<UserAction> list = new ArrayList<>();

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Store store, List<UserAction> actions) throws SQLException {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, store);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) throws SQLException {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Store store = new SqlTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAction(output),
                new EditAction(output),
                new DeleteAction(output),
                new FindIDAction(output),
                new FindNameAction(output),
                new ExitAction()
        };
        list = Arrays.asList(actions);
        new StartUI(output).init(input, store, list);
    }
}
