package ru.caselab.field;

import ru.caselab.state.CellState;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private boolean isDead = false;
    private int safeDecksNum;
    private final int x;
    private final int y;
    private final int position;
    private final List<Cell> cells = new ArrayList<>();

    public Ship(int size, int position, int x, int y) {
        this.safeDecksNum = size;
        this.position = position;
        this.x = x;
        this.y = y;
    }

    public boolean isDead() {
        return isDead;
    }

    public int getSafeDecksNum() {
        return safeDecksNum;
    }

    public int getPosition() {
        return position;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addCell(Cell cell) {
        cells.add(cell);
        cell.setShip(this);
        cell.setCellState(CellState.SHIP);
    }

    private void drawn() {
        isDead = true;
        for (Cell cell : cells) {
            cell.setCellState(CellState.DEAD);
        }
    }

    public void wound(Cell cell) {
        safeDecksNum--;
        if (safeDecksNum == 0) {
            drawn();
        } else {
            cell.setCellState(CellState.WOUNDED);
        }
    }
}
