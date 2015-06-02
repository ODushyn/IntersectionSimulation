package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Timer;

/**
 * Created by Oleksander.Dushyn on 5/25/2015.
 */
public class Vehicle {

    private long timeArrived;
    private long timeLeave;
    private double state = 1;
    private boolean isLeave;

    public Vehicle(long timeArrived) {
        this.timeArrived = timeArrived;
    }

    public long getTimeWaiting(){
        return (timeLeave - timeArrived)/ 1000;
    }

    public double getState() {
        return state;
    }

    public void decreaseState(double delta){
        //delta is always negative
        state += delta;
    }

    public boolean isLeave(double arrivalRate){
        state -= arrivalRate;
        if(state > 0){
            return false;
        }
        timeLeave = Timer.currentTime();
        return true;
    }
}
