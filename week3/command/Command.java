package command;

interface Command {
	public void execute();
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
	
}

