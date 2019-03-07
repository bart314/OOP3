package command;

interface Command {
	void execute();
	void undo();
}


class goLeftCommand implements Command {
	private Character _element;
	
	public goLeftCommand(final Character element) {
		_element = element;
	}

	@Override
	public void execute() {
		_element.goLeft();
	}

	public void undo() {
		_element.goBack();
	}
	
}

class goRightCommand implements Command {
	private Character _element;
	
	public goRightCommand(final Character element) {
		_element = element;
	}
	@Override
	public void execute() {
		_element.goRight();
	}

	public void undo() {
		_element.goBack();
	}
	
}

