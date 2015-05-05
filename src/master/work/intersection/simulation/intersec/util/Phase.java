package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Phase {
    private Direction directions[];
    private long redStartTime;
    private long greenStartTime;
    private int name;

    public Phase(int name) {
        this.name = name;
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

    public int getName() {
        return name;
    }

}
