package master.work.intersection.simulation.util;

import master.work.intersection.simulation.intersec.util.Phase;

/**
 * Created by Oleksander.Dushyn on 5/8/2015.
 */
public class Decision {

    private Phase nextGreenPhase;
    private Phase currentGreenPhase;
    private int delayTimeOfGreenPhase;

    public Phase getNextGreenPhase() {
        return nextGreenPhase;
    }

    public void setNextGreenPhase(Phase nextGreenPhase) {
        this.nextGreenPhase = nextGreenPhase;
    }

    public Phase getCurrentGreenPhase() {
        return currentGreenPhase;
    }

    public void setCurrentGreenPhase(Phase currentGreenPhase) {
        this.currentGreenPhase = currentGreenPhase;
    }

    public int getDelayTimeOfGreenPhase() {
        return delayTimeOfGreenPhase;
    }

    public void setDelayTimeOfGreenPhase(int delayTimeOfGreenPhase) {
        this.delayTimeOfGreenPhase = delayTimeOfGreenPhase;
    }
}

