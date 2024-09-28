package ru.caselab.player;

import ru.caselab.field.Move;

import java.util.Random;

public class Computer extends Player {
    public Computer(String name) {
        this.name = name;
    }

    @Override
    public void arrangeShips() {
        shipsArranger.autoArrangeShips(field);
    }

    @Override
    public Move makeMove() {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);
        return new Move(x, y);
    }

    @Override
    public void endMove() {
        System.out.println("Computer is ending its move \n");
    }
}
