package command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
    private List<Command> history = new ArrayList<>();
    private Command command;

    public void setCommand (Command c) {
        history.add(c);
        command = c;
    }

    public void buttonPressed() {
        command.execute();
    }

    public void undo() {
        if (history.size() > 0) {
            Command c = history.remove(0);
            c.undo();
        }
    }
}
