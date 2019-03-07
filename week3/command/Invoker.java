package command;

import java.util.ArrayList;

public class Invoker {
    ArrayList<Command> _history = new ArrayList<>();
    Command _command;

    public void setCommand (Command c) {
        _history.add(c);
        _command = c;
    }

    public void buttonPressed() {
        _command.execute();
    }

    public void undo() {
        if (_history.size() > 0) {
            Command c = _history.remove(0);
            c.undo();
        }
    }
}
