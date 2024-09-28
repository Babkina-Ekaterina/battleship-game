package ru.caselab.inputer;

import ru.caselab.field.Move;
import ru.caselab.field.Ship;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHumanInputer implements HumanInputer {
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public String askForName() {
        System.out.println("Player, please, input your name");
        String playerName = SCANNER.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println();
        return playerName;
    }

    @Override
    public List<Ship> askForShipArrange(String name) {
        List<Ship> ships = new ArrayList<>();
        System.out.println(name + ", please, arrange your ships");
        for (int deckNum = 4; deckNum > 0; deckNum--) {
            int shipNum = 5 - deckNum;
            for (int shipInd = 0; shipInd < shipNum; shipInd++) {
                System.out.println("Arrange a " + deckNum + "-deck ship. It remains to arrange: " + (shipNum - shipInd));

                System.out.println("Input x coord (letter): ");
                char xChar = SCANNER.next().toUpperCase().charAt(0);
                int x = xChar - 'A';

                System.out.println("Input y coord (number): ");
                int y = SCANNER.nextInt() - 1;

                int position = 1;
                if (deckNum != 1) {
                    System.out.println("Choose position: 1 - horizontal, 2 - vertical");
                    position = SCANNER.nextInt();
                }

                Ship ship = new Ship(deckNum, position, x, y);
                ships.add(ship);
                System.out.println();
            }
        }

        return ships;
    }

    @Override
    public void askForContinue(String name) {
        System.out.println(name + ", please, write \"1\" to continue...");
        SCANNER.next();
    }

    @Override
    public Move askForMove(String name) {
        System.out.println(name + ", please, make a move");

        System.out.println("Input x coord (letter): ");
        char xChar = SCANNER.next().toUpperCase().charAt(0);
        int x = xChar - 'A';

        System.out.println("Input y coord (number): ");
        int y = SCANNER.nextInt() - 1;
        System.out.println();

        return new Move(x, y);
    }
}
