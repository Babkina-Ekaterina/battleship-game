package ru.caselab.player;

import ru.caselab.field.Move;
import ru.caselab.field.Ship;

import java.util.Random;

public class Computer extends Player {
    public Computer(String name) {
        this.name = name;
    }

    @Override
    public void arrangeShips() {
        Ship ship = new Ship(4, 1, 0, 0);
        int position = ship.getPosition();
        int deckNum = ship.getSafeDecksNum();
        int x = ship.getX();
        int y = ship.getY();

        if (position == 1) {
            for (int offset = 0; offset < deckNum; offset++) {
                ship.addCell(field.getCell(x + offset, y));
            }
        } else if (position == 2) {
            for (int offset = 0; offset < deckNum; offset++) {
                ship.addCell(field.getCell(x, y + offset));
            }
        }
        field.addShip(ship);
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
