package ru.caselab.inputer;

import ru.caselab.field.Move;
import ru.caselab.field.Ship;

import java.util.List;

public interface HumanInputer {
    String askForName();
    List<Ship> askForShipArrange(String name);
    void askForContinue(String name);
    Move askForMove(String name);
}
