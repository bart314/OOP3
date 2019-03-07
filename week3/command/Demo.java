package command;

public class Demo {
	public static void main(String[] args) {
		//receiver
//		final Character pacman = new Pacman();
		final Character blinky = new Blinky();
		
		//concrete commands
		Command left = new goLeftCommand(blinky);
		Command right = new goRightCommand(blinky);
		
		//invoke commands
		left.execute();
		right.execute();
	}
}
