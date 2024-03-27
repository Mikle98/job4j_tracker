package ru.job4j.tracker;

import java.sql.SQLException;

public class FindIDAction implements UserAction {
    private Output out;

    public FindIDAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Store store) throws SQLException {
        out.println("=== Find item by id ===");
        int id = input.askInt("Enter id: ");
        Item item = store.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
