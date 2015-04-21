package master.work.intersection.simulation.intersec.util;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction {

    private int numberOfVehicles;
    private int waitingTime;

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
}
