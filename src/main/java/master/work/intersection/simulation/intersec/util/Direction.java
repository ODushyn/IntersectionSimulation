package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction extends Thread{

    private double queue;
    //TODO: make this parameter work (measure waiting time for each direction)
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
        if(active && Controller.isTimeUp(Controller.currentTime(), lastVehicleRemoveTime, Controller.UNIT_OF_TIME)) {
            removeVehicleFromQueue();

        }

    }

    private void simulateDistribution(){
        if(Controller.isTimeUp(Controller.currentTime(), lastDistributionTime, Controller.UNIT_OF_TIME)) {
            addVehiclesToQueue();
        }
    }

    private void addVehiclesToQueue(){
        this.queue += Intersection.distribution.getNumberOfArrivedVehicles();
        lastDistributionTime = Controller.currentTime();
    }

    private void removeVehicleFromQueue(){
        if(queue > 0){
            this.queue -= Controller.VEHICLE_LEAVING_RATE;
        }
        this.lastVehicleRemoveTime = Controller.currentTime();
    }

    public double getQueue() {
        return Math.floor(queue);
    }

    public int getRedWaitingTime() {
        return redWaitingTime;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }
}
