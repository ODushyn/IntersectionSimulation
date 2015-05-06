package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction extends Thread{

    private int queue;
    //TODO: make this parameter work (measure waitin time for each direction)
    private int redWaitingTime;
    private boolean active;
    private long lastVehicleRemoveTime = Controller.currentTime();
    private long lastDistributionTime = Controller.currentTime();

    public Direction(int name) {
        setName(String.valueOf(name));
    }

    @Override
    public void run() {
        while(Controller.isOn()) {
            simulateDistribution();
            simulateVehicleMoveAway();
            //System.out.println(getName() + " " + queue);
        }
    }

    private void simulateVehicleMoveAway(){
        if(active && Controller.isTimeUp(Controller.currentTime(), lastVehicleRemoveTime, Controller.VEHICLE_REMOVE_PERIOD_TIME)) {
            removeVehicleFromQueue();

        }

    }

    private void simulateDistribution(){
        if(Controller.isTimeUp(Controller.currentTime(), lastDistributionTime, Controller.DISTRIBUTION_PERIOD_TIME)) {
            addVehiclesToQueue(Intersection.distribution.getNumberOfArrivedVehicles());
        }
    }

    private void addVehiclesToQueue(int n){
        this.queue += n;
        lastDistributionTime = Controller.currentTime();
    }

    private void removeVehicleFromQueue(){
        if(queue > 0){
            this.queue -= 1;
        }
        this.lastVehicleRemoveTime = Controller.currentTime();
    }

    public int getQueue() {
        return queue;
    }

    public int getRedWaitingTime() {
        return redWaitingTime;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }
}
