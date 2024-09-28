package ru.caselab.inputter;

import ru.caselab.enumeration.ShipArrangeMode;
import ru.caselab.enumeration.ShipPosition;
import ru.caselab.field.Move;
import ru.caselab.field.Ship;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleHumanInputter implements HumanInputter {
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
    public Ship askForShipArrange(String name, int deckNum, int shipInd) {
        int shipNum = 5 - deckNum;

        System.out.println(name + ", please, arrange a " + deckNum + "-deck ship. It remains to arrange: " + (shipNum - shipInd));

        int x = readX();
        int y = readY();

        ShipPosition position = ShipPosition.HORIZONTAL;
        if (deckNum != 1) {
            position = readPosition();
        }

        Ship ship = new Ship(deckNum, position, x, y);
        System.out.println();


        return ship;
    }

    @Override
    public void askForContinue(String name) {
        System.out.println(name + ", please, write \"1\" to continue...");
        while (true) {
            String input = SCANNER.next();
            if ("1".equals(input)) {
                break;
            }
        }
    }

    @Override
    public Move askForMove(String name) {
        System.out.println(name + ", please, make a move");

        int x = readX();
        int y = readY();

        return new Move(x, y);
    }

    @Override
    public void askForNewShipPlace() {
        System.out.println("Invalid input. Choose another place for this ship");
    }

    @Override
    public ShipArrangeMode askForArrangeMode() {
        System.out.print("Choose ship arrange mode: 1 - auto, 2 - manual: ");
        while (true) {
            try {
                int mode = SCANNER.nextInt();
                if (mode == 1) {
                    return ShipArrangeMode.AUTO;
                }
                if (mode == 2) {
                    return ShipArrangeMode.MANUAL;
                }
                System.out.println("Invalid input. Please choose 1 or 2");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                SCANNER.next();
            }
        }
    }

    private int readX() {
        System.out.print("Input x coord (letter A-J or a-j): ");
        while (true) {
            String input = SCANNER.next().toUpperCase();
            if (input.length() == 1 && input.charAt(0) >= 'A' && input.charAt(0) <= 'J') {
                return input.charAt(0) - 'A';
            }
            System.out.println("Invalid input. Please enter a letter A-J or a-j");
        }
    }

    private int readY() {
        System.out.print("Input y coord (number 1-10): ");
        while (true) {
            try {
                int y = SCANNER.nextInt() - 1;
                if (y >= 0 && y <= 9) {
                    return y;
                }
                System.out.println("Invalid input. Please enter a number from 1 to 10");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                SCANNER.next();
            }
        }
    }

    private ShipPosition readPosition() {
        System.out.print("Choose position: 1 - horizontal, 2 - vertical: ");
        while (true) {
            try {
                int position = SCANNER.nextInt();
                if (position == 1) {
                    return ShipPosition.HORIZONTAL;
                }
                if (position == 2) {
                    return ShipPosition.VERTICAL;
                }
                System.out.println("Invalid input. Please choose 1 or 2");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                SCANNER.next();
            }
        }
    }
}
