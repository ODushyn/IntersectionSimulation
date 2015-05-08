package master.work.intersection.simulation.util;

/**
 * Created by Oleksander.Dushyn on 5/8/2015.
 */
public class Decision {

    private int nextGreenPhase;
    private int currentGreenPhase;
    private int delayTimeOfGreenPhase;

    public int getNextGreenPhase() {
        return nextGreenPhase;
    }

    public void setNextGreenPhase(int nextGreenPhase) {
        this.nextGreenPhase = nextGreenPhase;
    }

    public int getCurrentGreenPhase() {
        return currentGreenPhase;
    }

    public void setCurrentGreenPhase(int currentGreenPhase) {
        this.currentGreenPhase = currentGreenPhase;
    }

    public int getDelayTimeOfGreenPhase() {
        return delayTimeOfGreenPhase;
    }

    public void setDelayTimeOfGreenPhase(int delayTimeOfGreenPhase) {
        this.delayTimeOfGreenPhase = delayTimeOfGreenPhase;
    }
}

