package ru.caselab.player;

import ru.caselab.field.Move;
import ru.caselab.inputer.HumanInputer;

public class Human extends Player{
    private final HumanInputer humanInputer;

    public Human(HumanInputer humanInputer) {
        this.humanInputer = humanInputer;
        name = humanInputer.askForName();
    }

    @Override
    public void arrangeShips() {
        shipsArranger.manualArrangeShips(field, humanInputer.askForShipArrange(name));
    }

    @Override
    public Move makeMove() {
        return humanInputer.askForMove(name);
    }

    @Override
    public void endMove() {
        humanInputer.askForContinue(name);
    }
}
