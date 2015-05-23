package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.arrivalrate.ArrivalRate;
import master.work.intersection.simulation.arrivalrate.FloatArrivalRate;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.util.Constants;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction extends Thread{

    private ArrivalRate arrivalRate;
    private double queue;
    private boolean active;

    public Direction(int name) {
        this.arrivalRate = new FloatArrivalRate();
        this.queue = 0;
        setName(String.valueOf(name));
    }

    @Override
    public synchronized void run(){
        try {
            arrivalRate.control(this);
            while(Controller.isOn()) {
                simulateVehiclesComeIn();
                simulateVehicleMoveAway();
                this.wait(Controller.UNIT_OF_TIME);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void simulateVehiclesComeIn(){
        this.queue += arrivalRate.arrivedVehicles();
    }

    private void simulateVehicleMoveAway(){
        if(active) {
            removeVehicleFromQueue();
        }
    }

    private void removeVehicleFromQueue(){
        if(queue > 0){
            this.queue -= Constants.DEFAULT_VEHICLE_LEAVING_RATE;
        }
    }

    public double getQueue() {
        if(queue < 0){
            return 0;
        }
        return Math.floor(queue);
    }

    public double getArrivalRate() {
        return arrivalRate.getArrivalRate();
    }

    public void setQueue(double queue) {
        this.queue = queue;
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public void setArrivalRate(ArrivalRate arrivalRate) {
        this.arrivalRate = arrivalRate;
    }

    public ArrivalRate getArrivalRateObj() {
        return arrivalRate;
    }

}
