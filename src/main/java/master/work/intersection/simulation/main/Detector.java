package master.work.intersection.simulation.main;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Detector {

    private int delayTimeOfRedPhase;
    private int waitingVehiclesOfRedPhase;
    private int waitingVehiclesOfNextGreenPhase;
    private int waitingVehiclesOfCurrentGreenPhase;

    public int getDelayTimeOfRedPhase() {
        return delayTimeOfRedPhase;
    }

    public void setDelayTimeOfRedPhase(int delayTimeOfRedPhase) {
        this.delayTimeOfRedPhase = delayTimeOfRedPhase;
    }

    public int getWaitingVehiclesOfRedPhase() {
        return waitingVehiclesOfRedPhase;
    }

    public void setWaitingVehiclesOfRedPhase(int waitingVehiclesOfRedPhase) {
        this.waitingVehiclesOfRedPhase = waitingVehiclesOfRedPhase;
    }

    public int getWaitingVehiclesOfNextGreenPhase() {
        return waitingVehiclesOfNextGreenPhase;
    }

    public void setWaitingVehiclesOfNextGreenPhase(int waitingVehiclesOfNextGreenPhase) {
        this.waitingVehiclesOfNextGreenPhase = waitingVehiclesOfNextGreenPhase;
    }

    public int getWaitingVehiclesOfCurrentGreenPhase() {
        return waitingVehiclesOfCurrentGreenPhase;
    }

    public void setWaitingVehiclesOfCurrentGreenPhase(int waitingVehiclesOfCurrentGreenPhase) {
        this.waitingVehiclesOfCurrentGreenPhase = waitingVehiclesOfCurrentGreenPhase;
    }
}
