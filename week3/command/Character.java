package command;

public interface Character {
	void goLeft();
	void goRight();
	void goBack();
}


class Pacman implements Character {
	
	public void goLeft() {
		System.out.println("Pacman goes left.");
	}
	
	public void goRight() {
		System.out.println("Pacman goes right");
	}

	public void goBack() {
		System.out.println("Pacman goes back");
	}
}


class Blinky implements Character {
	
	public void goLeft() {
		System.out.println("Blinky goes left.");
	}

	public void goRight() {
		System.out.println("Blinky goes right");
	}

	public void goBack() {
		System.out.println("Blinky goes back");
	}
}