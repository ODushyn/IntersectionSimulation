package master.work.intersection.simulation.fuzzy;

/**
 * Created by Oleksander.Dushyn on 5/10/2015.
 */
public class UrgencyEvaluatorInput {

    private int phaseNumber;
    private long delayTimeOfRedPhase;
    private int waitingVehiclesOfRedPhase;

    public int getPhaseNumber() {
        return phaseNumber;
    }

    public void setPhaseNumber(int phaseNumber) {
        this.phaseNumber = phaseNumber;
    }

    public long getDelayTimeOfRedPhase() {
        return delayTimeOfRedPhase;
    }

    public void setDelayTimeOfRedPhase(long delayTimeOfRedPhase) {
        this.delayTimeOfRedPhase = delayTimeOfRedPhase;
    }

    public int getWaitingVehiclesOfRedPhase() {
        return waitingVehiclesOfRedPhase;
    }

    public void setWaitingVehiclesOfRedPhase(int waitingVehiclesOfRedPhase) {
        this.waitingVehiclesOfRedPhase = waitingVehiclesOfRedPhase;
    }

}
