package command;

public class Invoker {
    Command _command;

    public void setCommand (Command c) {
        _command = c;
    }

    public void buttonPressed() {
        _command.execute();
    }
}
