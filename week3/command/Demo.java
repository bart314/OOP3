package command;

public class Demo {
	public static void main(String[] args) {
		//concrete receivers
		final Character pacman = new Pacman();
		final Character blinky = new Blinky();

		//concrete commands
		Command left = new goLeftCommand(blinky);
		Command right = new goRightCommand(blinky);

		// invoker
		Invoker v = new Invoker();
		v.setCommand(left);
		v.buttonPressed();

		v.setCommand(right);
		v.buttonPressed();

		v.undo();
	}
}