package master.work.intersection.simulation.intersec.util;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction {

    private int directionName;
    private int numberOfVehicles;
    private int waitingTime;

    public Direction(int directionName) {
        this.directionName = directionName;
    }

    public void addVehiclesToQueue(int n){

        this.numberOfVehicles += n;
    }

    public void removeVehicleFromQueue(){
        if(numberOfVehicles > 0){
            this.numberOfVehicles -= 1;
        }

    }

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

    public int getDirectionName() {
        return directionName;
    }

    public void setDirectionName(int directionName) {
        this.directionName = directionName;
    }
}
