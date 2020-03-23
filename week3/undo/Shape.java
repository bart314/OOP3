package undo;



public class Shape {
    private String type;
    private String color;
    private boolean filled;


    public Shape(String type) {
        this.type = type;
    }



    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        String f = filled ? "opaque" : "transparant";
        return String.format("Shape of type %s with color %s; %s", type, color, f);
    }
}
