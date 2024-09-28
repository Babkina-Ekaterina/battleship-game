package ru.caselab.field;

import ru.caselab.enumeration.CellState;

public class Cell {
    private CellState cellState = CellState.EMPTY;
    private Ship ship;

    public CellState getCellState() {
        return cellState;
    }
    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
