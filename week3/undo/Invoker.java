package undo;

import java.util.*;

public class Invoker {
    private final Deque<Command> commandStack = new ArrayDeque<>();

    void test() {
        // toevoegen shape 1: groene gevulde cirkel
        Shape s1 = new Shape("Cirkel");
        execute(new setColorCommand(s1, "#0f0"));
        execute(new fillShapeCommand(s1));
        execute(new addShapeCommand(s1));

        System.out.println(Canvas.getCanvas());

        // toevoegen shape 2: rode open polygoon
        Shape s2 = new Shape("Polygone");
        execute(new setColorCommand(s2, "#f00"));
        execute(new addShapeCommand(s2));

        System.out.println(Canvas.getCanvas());

        // Oeps, we wilden die polygoon toch gevuld hebben!
        System.out.println("Oeps, we wilden die polygoon toch gevuld hebben!");
        Shape tmp = undo();
        execute(new fillShapeCommand(tmp));
        execute(new addShapeCommand(tmp));

        System.out.println(Canvas.getCanvas());
    }

    private void execute(Command cmd) {
        cmd.execute();
        commandStack.push(cmd);
    }

    private Shape undo() {
        return commandStack.pop().undo();
    }


    public static void main(String[] args) {
        new Invoker().test();
    }


}

