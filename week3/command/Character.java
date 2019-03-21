package command;

public interface Character {
	void goLeft();
	void goRight();
}


class Pacman implements Character {
	
	public void goLeft() {
		System.out.println("Pacman goes left.");
	}
	
	public void goRight() {
		System.out.println("Pacman goes right");
	}
}


class Blinky implements Character {
	
	public void goLeft() {
		System.out.println("Blinky goes left.");
	}

	public void goRight() {
		System.out.println("Blinky goes right");
	}
}