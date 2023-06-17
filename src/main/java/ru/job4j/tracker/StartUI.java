package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private Output out;
    private static List<UserAction> list = new ArrayList<>();

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        list.add(new CreateAction(output));
        list.add(new ShowAction(output));
        list.add(new EditAction(output));
        list.add(new DeleteAction(output));
        list.add(new FindIDAction(output));
        list.add(new FindNameAction(output));
        list.add(new ExitAction());
        new StartUI(output).init(input, tracker, list);
    }
}
