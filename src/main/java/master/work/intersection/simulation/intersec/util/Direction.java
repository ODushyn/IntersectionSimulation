package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Timer;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction extends Thread{

    private Distribution distribution;
    private double queue;
    private boolean active;
    private long lastVehicleRemoveTime;
    private long lastDistributionTime;

    public Direction(int name, Distribution distribution) {
        this.distribution = distribution;
        this.queue = 0;
        this.lastVehicleRemoveTime = Timer.currentTime();
        this.lastDistributionTime = Timer.currentTime();
        setName(String.valueOf(name));
    }

    @Override
    public void run(){
        try {
            while(Controller.isOn()) {
                simulateDistribution();
                simulateVehicleMoveAway();
                this.sleep(Controller.UNIT_OF_TIME);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setArrivalRate(double rate){
        this.distribution.setArrivalRate(rate);
    }

    private void simulateVehicleMoveAway(){
        if(active) {
            removeVehicleFromQueue();
        }
    }

    private void simulateDistribution(){
        addVehiclesToQueue();
    }

    private void addVehiclesToQueue(){
        this.queue += distribution.arrivedVehicles();
        lastDistributionTime = Timer.currentTime();
    }

    private void removeVehicleFromQueue(){
        if(queue > 0){
            this.queue -= Controller.DEFAULT_VEHICLE_LEAVING_RATE;
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

    public void setActive(boolean isActive) {
        this.active = isActive;
    }
}
