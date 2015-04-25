package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.main.Controller;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Phase {
    private Direction activeDirections[];
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

    public void reset(){
        this.redStartTime = Controller.currentTime();
        this.greenStartTime = 0;
    }

    public void setUp(){
        this.redStartTime = 0;
        this.greenStartTime = Controller.currentTime();
    }

    public Direction[] getActiveDirections() {
        return activeDirections;
    }

    public void setActiveDirections(Direction... activeDirections) {
        this.activeDirections = activeDirections;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

}
