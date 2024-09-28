package ru.caselab.drawer;

import ru.caselab.field.Field;
import ru.caselab.player.Human;
import ru.caselab.player.Player;
import ru.caselab.enumeration.CellState;

public class ConsoleDrawer implements Drawer {
    @Override
    public void drawPlayerField(Player player) {
        if (player instanceof Human) {
            System.out.println("Your field:");
            System.out.println("   A B C D E F G H I J");
            for (int rowInd = 0; rowInd < Field.FIELD_SIZE; rowInd++) {
                System.out.print(rowInd + 1);

                if (rowInd < Field.FIELD_SIZE - 1) {
                    System.out.print("  ");
                } else {
                    System.out.print(" ");
                }

                for (int columnInd = 0; columnInd < Field.FIELD_SIZE; columnInd++) {
                    CellState cellState = player.getField().getCell(columnInd, rowInd).getCellState();
                    switch (cellState) {
                        case EMPTY -> System.out.print(".");
                        case SHIP -> System.out.print("@");
                        case WOUNDED -> System.out.print("V");
                        case DEAD -> System.out.print("X");
                        case MISS -> System.out.print("*");
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    @Override
    public void drawEnemyField(Player enemy) {
        System.out.println("Enemy's field:");
        System.out.println("   A B C D E F G H I J");
        for (int rowInd = 0; rowInd < Field.FIELD_SIZE; rowInd++) {
            System.out.print(rowInd + 1);

            if (rowInd < Field.FIELD_SIZE - 1) {
                System.out.print("  ");
            } else {
                System.out.print(" ");
            }

            for (int columnInd = 0; columnInd < Field.FIELD_SIZE; columnInd++) {
                CellState cellState = enemy.getField().getCell(columnInd, rowInd).getCellState();
                switch (cellState) {
                    case EMPTY, SHIP -> System.out.print(".");
                    case WOUNDED -> System.out.print("V");
                    case DEAD -> System.out.print("X");
                    case MISS -> System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();

    }

    @Override
    public void drawMove(Player player, Player enemy) {
        System.out.println("\n\n\n" + player.getName() + " is making move \n");
        if (player instanceof Human) {
            drawPlayerField(player);
            drawEnemyField(enemy);
        }
    }

    @Override
    public void drawSkip(Player player, Player enemy) {
        if (player instanceof Human && enemy instanceof Human) {
            for (int lineBreakInd = 0; lineBreakInd < 40; lineBreakInd++) {
                System.out.println();
            }
        }
    }

    @Override
    public void drawGameEnd(Player winner) {
        System.out.println("Game is over! Winner: " + winner.getName());
    }

    @Override
    public void drawMoveResult(CellState newCellState) {
        switch (newCellState) {
            case MISS -> System.out.println("Miss! \n");
            case WOUNDED -> System.out.println("Wounded! \n");
            case DEAD -> System.out.println("Drawn! \n");
        }

    }

    @Override
    public void drawWrongMove() {
        System.out.println("\nYou have already targeted this cell. Please choose another one");
    }
}
