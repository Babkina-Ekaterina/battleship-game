package ru.caselab.field;

import java.util.ArrayList;
import java.util.List;

public class Field {
    public static final int FIELD_SIZE = 10;
    private final Cell[][] cells = new Cell[FIELD_SIZE][FIELD_SIZE];
    private final List<Ship> ships = new ArrayList<>();

    public Field() {
        for (int rowInd = 0; rowInd < FIELD_SIZE; rowInd++) {
            for (int columnInd = 0; columnInd < FIELD_SIZE; columnInd++) {
                cells[rowInd][columnInd] = new Cell();
            }
        }
    }

    public void addShip(Ship ship) {
        ships.add(ship);
    }

    public boolean areThereAnyShips() {
        for (Ship ship : ships) {
            if (!ship.isDead()) {
                return true;
            }
        }
        return false;
    }

    public Cell getCell(int x, int y) {
        return cells[y][x];
    }
}
