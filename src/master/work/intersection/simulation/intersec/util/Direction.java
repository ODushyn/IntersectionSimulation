package master.work.intersection.simulation.intersec.util;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction {

    private int name;
    private int numberOfVehicles;
    private int redWaitingTime;

    public Direction(int name) {
        this.name = name;
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

    public int getRedWaitingTime() {
        return redWaitingTime;
    }

    public void setRedWaitingTime(int redWaitingTime) {
        this.redWaitingTime = redWaitingTime;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }
}
