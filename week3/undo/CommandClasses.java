package undo;

class addShapeCommand implements Command {
    private Shape shape;

    addShapeCommand(Shape shape) {
        this.shape = shape;
    }

    @Override
    public Shape execute() {
        Canvas.getCanvas().addShape(this.shape);
        return this.shape;
    }

    @Override
    public Shape undo() {
        return Canvas.getCanvas().removeShape();
    }
}



class fillShapeCommand implements Command {
    private Shape shape;
    private boolean isFilled;

    fillShapeCommand(Shape shape) {
        this.shape = shape;
        this.isFilled = true;
    }

    @Override
    public Shape execute() {
        this.shape.setFilled(this.isFilled);
        toggle();
        return this.shape;
    }

    @Override
    public Shape undo() {
        this.shape.setFilled(!this.isFilled);
        toggle();
        return this.shape;
    }

    private void toggle() {
        this.isFilled = !this.isFilled;
    }
}


class setColorCommand implements Command {
    private Shape shape;
    private String oldColor;
    private String newColor;

    setColorCommand(Shape shape, String color) {
        this.shape = shape;
        this.newColor = color;
    }

    @Override
    public Shape execute() {
        this.oldColor = this.shape.getColor();
        this.shape.setColor(this.newColor);
        return this.shape;

    }

    @Override
    public Shape undo() {
        this.shape.setColor(this.oldColor);
        return this.shape;
    }
}

interface Command{
    public Shape execute();
    public Shape undo();
}