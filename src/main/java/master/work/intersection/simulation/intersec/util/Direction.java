package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.main.Timer;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction extends Thread{

    private double queue;
    //TODO: make this parameter work (measure waiting time for each direction)
    private int redWaitingTime;
    //TODO: is this parameter needed?
    private boolean active;
    private long lastVehicleRemoveTime;
    private long lastDistributionTime;

    public Direction(int name) {
        queue = 0;
        lastVehicleRemoveTime = Timer.currentTime();
        lastDistributionTime = Timer.currentTime();
        setName(String.valueOf(name));
    }

    @Override
    public void run() {
        while(Controller.isOn()) {
            simulateDistribution();
            simulateVehicleMoveAway();
        }
    }

    private void simulateVehicleMoveAway(){
        if(active && Timer.repeat(Timer.currentTime(), lastVehicleRemoveTime, Controller.UNIT_OF_TIME)) {
            removeVehicleFromQueue();

        }

    }

    private void simulateDistribution(){
        if(Timer.repeat(Timer.currentTime(), lastDistributionTime, Controller.UNIT_OF_TIME)) {
            addVehiclesToQueue();
        }
    }

    private void addVehiclesToQueue(){
        this.queue += Intersection.distribution.arrivedVehicles();
        lastDistributionTime = Timer.currentTime();
    }

    private void removeVehicleFromQueue(){
        if(queue > 0){
            this.queue -= Controller.VEHICLE_LEAVING_RATE;
        }
        this.lastVehicleRemoveTime = Timer.currentTime();
    }

    public double getQueue() {
        if(queue < 0){
            return 0;
        }
        return Math.floor(queue);
    }

    public void setQueue(double queue) {
        this.queue = queue;
    }

    public int getRedWaitingTime() {
        return redWaitingTime;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }
}
