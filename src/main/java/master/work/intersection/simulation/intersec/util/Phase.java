package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Phase {
    private Direction directions[];
    private long redStartTime;
    private long greenStartTime;
    private int number;

    public Phase(int number) {
        this.number = number;
        this.redStartTime = Controller.currentTime();
    }

    public long redWaitingTime(){
        if(this.redStartTime == 0){
            return 0;
        }
        return Controller.currentTime() - redStartTime;
    }

    public long greenWaitingTime(){
        if(this.greenStartTime == 0){
            return 0;
        }
        return Controller.currentTime() - greenStartTime;
    }

    public int waitingVehicles(){
        int vehiclesTotal = 0;
        for(Direction d : directions){
            vehiclesTotal += d.getQueue();
        }
        return vehiclesTotal;
    }

    public void deactivate(){
        this.redStartTime = Controller.currentTime();
        this.greenStartTime = 0;
        deactivateDirections();
    }

    public void activate(){
        this.redStartTime = 0;
        this.greenStartTime = Controller.currentTime();
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
