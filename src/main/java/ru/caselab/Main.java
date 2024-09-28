package ru.caselab;

import ru.caselab.drawer.ConsoleDrawer;
import ru.caselab.inputter.ConsoleHumanInputter;
import ru.caselab.player.Computer;
import ru.caselab.player.Human;
import ru.caselab.player.Player;

public class Main {
    public static void main(String[] args) {
//        Player player1 = new Human(new ConsoleHumanInputter());
//        Player player2 = new Human(new ConsoleHumanInputter());
        Player player1 = new Computer("Computer 1");
        Player player2 = new Computer("Computer 2");
        Game game = new Game(player1, player2, new ConsoleDrawer());
        game.play();
    }
}