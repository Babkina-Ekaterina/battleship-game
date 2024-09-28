package ru.caselab;

import ru.caselab.drawer.ConsoleDrawer;
import ru.caselab.inputer.ConsoleHumanInputer;
import ru.caselab.player.Computer;
import ru.caselab.player.Human;
import ru.caselab.player.Player;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Human(new ConsoleHumanInputer());
        Player player2 = new Human(new ConsoleHumanInputer());
//        Player player1 = new Computer("Computer 1");
//        Player player2 = new Computer("Computer 2");
        Game game = new Game(player1, player2, new ConsoleDrawer());
        game.play();
    }
}