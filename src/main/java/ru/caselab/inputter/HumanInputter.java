package ru.caselab.inputter;

import ru.caselab.enumeration.ShipArrangeMode;
import ru.caselab.field.Move;
import ru.caselab.field.Ship;

import java.util.List;

public interface HumanInputter {
    String askForName();
    Ship askForShipArrange(String name, int deckNum, int shipInd);
    void askForContinue(String name);
    Move askForMove(String name);
    void askForNewShipPlace();
    ShipArrangeMode askForArrangeMode();
}
