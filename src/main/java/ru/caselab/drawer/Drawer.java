package ru.caselab.drawer;

import ru.caselab.player.Player;
import ru.caselab.state.CellState;

public interface Drawer {
    void drawPlayerField(Player player);
    void drawEnemyField(Player enemy);
    void drawMove(Player player, Player enemy);
    void drawSkip(Player player, Player enemy);
    void drawGameEnd(Player winner);
    void drawMoveResult(CellState newCellState);
}
