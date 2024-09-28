package ru.caselab.player;

import ru.caselab.ShipsArranger;
import ru.caselab.field.Cell;
import ru.caselab.field.Field;
import ru.caselab.field.Move;

public abstract class Player {
    protected final Field field = new Field();
    protected final ShipsArranger shipsArranger = new ShipsArranger();
    protected String name;

    public abstract void arrangeShips();
    public abstract Move makeMove();
    public abstract void endMove();

    public Field getField() {
        return field;
    }
    public String getName() {
        return name;
    }
    public boolean hasAnyShips() {
        return field.areThereAnyShips();
    }
    public Cell getCell(int x, int y) {
        return field.getCell(x, y);
    }
}
