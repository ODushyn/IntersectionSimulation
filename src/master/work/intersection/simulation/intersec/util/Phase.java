package master.work.intersection.simulation.intersec.util;

import master.work.intersection.simulation.intersec.util.*;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Phase {
    private Direction activeDirections[];
    private int phaseTime;
    private int orderNumber;

    /*public void addDirections(Direction... directions){
        activeDirections = directions;
    }*/

    public int getPhaseTime() {
        return phaseTime;
    }

    public Direction[] getActiveDirections() {
        return activeDirections;
    }

    public void setActiveDirections(Direction... activeDirections) {
        this.activeDirections = activeDirections;
    }

    public void setPhaseTime(int phaseTime) {
        this.phaseTime = phaseTime;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
