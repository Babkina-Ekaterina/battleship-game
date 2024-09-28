package ru.caselab.player;

import ru.caselab.enumeration.ShipArrangeMode;
import ru.caselab.field.Move;
import ru.caselab.field.Ship;
import ru.caselab.inputter.HumanInputter;

public class Human extends Player {
    private final HumanInputter humanInputter;

    public Human(HumanInputter humanInputter) {
        this.humanInputter = humanInputter;
        name = humanInputter.askForName();
    }

    @Override
    public void arrangeShips() {
        if (humanInputter.askForArrangeMode() == ShipArrangeMode.AUTO) {
            shipsArranger.autoArrangeShips(field);
            return;
        }

        for (int deckNum = 4; deckNum > 0; deckNum--) {
            int shipNum = 5 - deckNum;
            for (int shipInd = 0; shipInd < shipNum; shipInd++) {
                Ship currShip = humanInputter.askForShipArrange(name, deckNum, shipInd);

                while (true) {
                    if (shipsArranger.manualArrangeShip(field, currShip)) {
                        break;
                    } else {
                        humanInputter.askForNewShipPlace();
                        currShip = humanInputter.askForShipArrange(name, deckNum, shipInd);
                    }
                }
            }
        }
    }

    @Override
    public Move makeMove() {
        return humanInputter.askForMove(name);
    }

    @Override
    public void endMove() {
        humanInputter.askForContinue(name);
    }
}
