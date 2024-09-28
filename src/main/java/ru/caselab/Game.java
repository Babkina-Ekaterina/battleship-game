package ru.caselab;

import ru.caselab.drawer.Drawer;
import ru.caselab.field.Cell;
import ru.caselab.field.Move;
import ru.caselab.player.Player;
import ru.caselab.state.CellState;
import ru.caselab.state.GameState;

import java.util.Random;

public class Game {
    private GameState gameState = GameState.IN_PROGRESS;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Player currentEnemy;
    private Player winner;
    private final Drawer drawer;

    public Game(Player player1, Player player2, Drawer drawer) {
        this.player1 = player1;
        this.player2 = player2;
        this.drawer = drawer;
    }

    public void play() {
        prepare();
        gameProgress();
        endGame();
    }

    private void prepare() {
        currentPlayer = determineFirstPlayer();
        currentEnemy = currentPlayer == player1 ? player2 : player1;

        for (int playerInd = 0; playerInd < 2; playerInd++) {
            currentPlayer.arrangeShips();
            drawer.drawPlayerField(currentPlayer);
            transferControl();
        }
    }

    private void gameProgress() {
        while (gameState != GameState.END) {
            drawer.drawMove(currentPlayer, currentEnemy);

            Move currentMove = currentPlayer.makeMove();
            Cell moveCell = currentEnemy.getCell(currentMove.x(), currentMove.y());

            boolean isMoveSuccessful = isMoveSuccessful(moveCell);

            drawer.drawMoveResult(moveCell.getCellState());

            checkGameStatus();

            drawer.drawEnemyField(currentEnemy);

            if (!isMoveSuccessful) {
                transferControl();
            }
        }
    }

    private boolean isMoveSuccessful(Cell moveCell) {
        switch (moveCell.getCellState()) {
            case EMPTY -> {
                moveCell.setCellState(CellState.MISS);
                return false;
            }
            case SHIP -> {
                moveCell.getShip().wound(moveCell);
                return true;
            }
        }
        return false;
    }

    private Player determineFirstPlayer() {
        Random random = new Random();
        return random.nextBoolean() ? player1 : player2;
    }

    private void swapPlayers() {
        Player temp = currentPlayer;
        currentPlayer = currentEnemy;
        currentEnemy = temp;
    }

    private void endGame() {
        drawer.drawGameEnd(winner);
    }

    private void checkGameStatus() {
        if (!currentEnemy.hasAnyShips()) {
            gameState = GameState.END;
            winner = currentPlayer;
        }
    }

    private void transferControl() {
        currentPlayer.endMove();
        drawer.drawSkip(currentPlayer, currentEnemy);
        swapPlayers();
    }
}
