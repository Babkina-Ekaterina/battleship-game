package ru.caselab;

import ru.caselab.field.Field;
import ru.caselab.field.Ship;

import java.util.List;

public class ShipsArranger {
    public void autoArrangeShips(Field field) {

    }

    public void manualArrangeShips(Field field, List<Ship> ships) {
        for (Ship ship : ships) {
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
    }
}
