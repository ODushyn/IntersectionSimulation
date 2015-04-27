package master.work.intersection.simulation.intersec.util;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction {

    private int name;
    private int queue;
    private int redWaitingTime;

    public Direction(int name) {
        this.name = name;
    }

    public void addVehiclesToQueue(int n){

        this.queue += n;
    }

    public void removeVehicleFromQueue(){
        if(queue > 0){
            this.queue -= 1;
        }

    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
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
