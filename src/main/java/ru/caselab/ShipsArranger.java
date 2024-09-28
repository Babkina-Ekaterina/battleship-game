package ru.caselab;

import ru.caselab.enumeration.ShipPosition;
import ru.caselab.field.Field;
import ru.caselab.field.Ship;
import ru.caselab.enumeration.CellState;

import java.util.Random;


public class ShipsArranger {
    public void autoArrangeShips(Field field) {
        Random random = new Random();

        int[] shipSizes = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1};
        for (int size : shipSizes) {
            while (true) {
                int x = random.nextInt(Field.FIELD_SIZE);
                int y = random.nextInt(Field.FIELD_SIZE);
                ShipPosition position = random.nextBoolean() ? ShipPosition.HORIZONTAL : ShipPosition.VERTICAL;
                Ship ship = new Ship(size, position, x, y);

                if (manualArrangeShip(field, ship)) {
                    break;
                }
            }
        }
    }

    public boolean manualArrangeShip(Field field, Ship ship) {
        ShipPosition position = ship.getPosition();
        int deckNum = ship.getSafeDecksNum();
        int x = ship.getX();
        int y = ship.getY();

        if ((position == ShipPosition.HORIZONTAL && (x + deckNum > Field.FIELD_SIZE)) ||
                (position == ShipPosition.VERTICAL && (y + deckNum > Field.FIELD_SIZE))) {
            return false;
        }

        if (!isShipBorderValid(field, x, y, deckNum, position)) {
            return false;
        }

        if (position == ShipPosition.HORIZONTAL) {
            for (int offset = 0; offset < deckNum; offset++) {
                ship.addCell(field.getCell(x + offset, y));
            }
        } else {
            for (int offset = 0; offset < deckNum; offset++) {
                ship.addCell(field.getCell(x, y + offset));
            }
        }

        field.addShip(ship);
        return true;
    }

    private boolean isCellBorderValid(Field field, int x, int y) {
        if (x < 0 || y < 0 || x >= Field.FIELD_SIZE || y >= Field.FIELD_SIZE) {
            return true;
        }

        return field.getCell(x, y).getCellState() == CellState.EMPTY;
    }

    private boolean isShipBorderValid(Field field, int x, int y, int deckNum, ShipPosition position) {
        if (position == ShipPosition.HORIZONTAL) {
            for (int dx = -1; dx <= deckNum; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (!isCellBorderValid(field, x + dx, y + dy)) {
                        return false;
                    }
                }
            }
        } else if (position == ShipPosition.VERTICAL) {
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= deckNum; dy++) {
                    if (!isCellBorderValid(field, x + dx, y + dy)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
