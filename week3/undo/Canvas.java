package undo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Canvas {
    private final Deque<Shape> shapes = new ArrayDeque<>();
    private static Canvas instance;

    private Canvas() { }
    public static Canvas getCanvas() {
        if (instance == null) {
            // Lazy loading
            instance = new Canvas();
        }
        return instance;
    }

    public void addShape (Shape s) {
        shapes.push(s);
    }

    public Shape removeShape(){
        return shapes.pop();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Contents of the canvas: \n");

        for (Shape s: shapes) {
            sb.append(s.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
