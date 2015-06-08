package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.arrivalrate.ArrivalRate;
import master.work.intersection.simulation.arrivalrate.FloatArrivalRate;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Timer;
import master.work.intersection.simulation.util.Constants;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Direction extends Thread{

    private ArrivalRate arrivalRate;
    private Deque<Vehicle> queue;
    private List<Vehicle> leavedVehicles;
    private boolean active;

    public Direction(int name) {
        this.arrivalRate = new FloatArrivalRate();
        this.queue = new ArrayDeque();
        this.leavedVehicles = new ArrayList<Vehicle>();
        setName(String.valueOf(name));
    }

    @Override
    public synchronized void run(){
        try {
            arrivalRate.control(this);
            while(Controller.isOn()) {
                if(Controller.isPaused){
                    this.wait();
                }
                simulateVehiclesComeIn();
                simulateVehicleMoveAway();
                this.wait(Controller.UNIT_OF_TIME);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void simulateVehiclesComeIn(){
        for(int i=0; i < arrivalRate.arrivedVehicles(); i++){
            this.queue.addLast(new Vehicle(Timer.currentTime()));
        }
    }

    private void simulateVehicleMoveAway(){
        if(active) {
            removeVehicleFromQueue();
        }
    }

    private void removeVehicleFromQueue(){
        if(queue.size() > 0 && queue.getFirst().isLeave(Constants.DEFAULT_VEHICLE_LEAVING_RATE)){
            leavedVehicles.add(queue.getFirst());
            //System.out.println("<<<----------------Direction: " + getName() + " " + queue.getFirst().getTimeWaiting());
            double delta = queue.pop().getState();
            if(!queue.isEmpty()){
                this.queue.getFirst().decreaseState(delta);
            }

        }
    }

    public double getQueue() {
        return queue.size();
    }

    public double getAverageTimeVehicleDelay(){
        double totalWaitingTime = 0;
        for(Vehicle vehicle: leavedVehicles){
            totalWaitingTime += vehicle.getTimeWaiting();
        }
        return totalWaitingTime /leavedVehicles.size();
    }

    public double getArrivalRate() {
        return arrivalRate.getArrivalRate();
    }

    public void setActive(boolean isActive) {
        this.active = isActive;
    }

    public boolean isActive() {
        return active;
    }

    public void setArrivalRate(ArrivalRate arrivalRate) {
        this.arrivalRate = arrivalRate;
    }

    public ArrivalRate getArrivalRateObj() {
        return arrivalRate;
    }

}
