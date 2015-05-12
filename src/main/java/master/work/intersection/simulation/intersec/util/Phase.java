package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Timer;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Phase {
    private int number;
    private Direction directions[];
    private long redStartTime;
    private long greenStartTime;
    private long phaseTime;
    //URGENCY is used in FuzzyUrgencyAndDelayController. For other controllers is used default value = 0
    private double urgency;

    public Phase(int number) {
        this.number = number;
        this.redStartTime = Timer.currentTime();
        this.phaseTime = Controller.PHASE_TIME;
    }

    public long redWaitingTime(){
        if(this.redStartTime == 0){
            return 0;
        }
        return Timer.currentTime() - redStartTime;
    }

    public long greenWaitingTime(){
        if(this.greenStartTime == 0){
            return 0;
        }
        return Timer.currentTime() - greenStartTime;
    }

    public int waitingVehicles(){
        int vehiclesTotal = 0;
        for(Direction d : directions){
            vehiclesTotal += d.getQueue();
        }
        return vehiclesTotal;
    }

    public void deactivate(){
        this.redStartTime = Timer.currentTime();
        this.greenStartTime = 0;
        deactivateDirections();
    }

    public void delay(long time){
        this.phaseTime += time;
    }
    public void activate(){
        this.redStartTime = 0;
        this.greenStartTime = Timer.currentTime();
        activateDirections();
    }

    private void activateDirections(){
        for(Direction d : directions){
            d.setActive(true);
        }
    }

    private void deactivateDirections(){
        for(Direction d : directions){
            d.setActive(false);
        }
    }

    public Direction[] getDirections() {
        return directions;
    }

    public void setDirections(Direction... directions) {
        this.directions = directions;
    }

    public int getNumber() {
        return number;
    }

    public double getUrgency() {
        return urgency;
    }

    public void setUrgency(double urgency) {
        this.urgency = urgency;
    }

    public long getPhaseTime() {
        return phaseTime;
    }

    public void setPhaseTime(long phaseTime) {
        this.phaseTime = phaseTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phase phase = (Phase) o;

        if (number != phase.number) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
