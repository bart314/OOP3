package command;

interface Command {
	void execute();
	void undo();
}


class goLeftCommand implements Command {
	private Character element;
	
	public goLeftCommand(final Character element) {
		this.element = element;
	}

	@Override
	public void execute() {
		element.goLeft();
	}

	public void undo() {
		element.goRight();
	}
	
}

class goRightCommand implements Command {
	private Character element;
	
	public goRightCommand(final Character element) {
		this.element = element;
	}
	@Override
	public void execute() {
		element.goRight();
	}

	public void undo() {
		element.goLeft();
	}
	
}

