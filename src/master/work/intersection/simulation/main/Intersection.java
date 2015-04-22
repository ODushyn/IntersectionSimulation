package master.work.intersection.simulation.main;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Intersection {

    protected Direction directions[];
    protected Phase phases[];
    protected Phase currentPhase;

    public Intersection(int phases, int directions){
        this.phases = new Phase[phases];
        this.directions = new Direction[directions];
    }

    protected abstract void init();

    public Direction getDirection(int number){
        return directions[number];
    }

    public Phase getCurrentPhase() {
        return currentPhase;
    }

    public Phase[] getPhases() {
        return phases;
    }

    public void setCurrentPhase(Phase phase) {
        this.currentPhase =  phase;
    }

    public void switchOnNextPhaseFromQueue(){
        if(currentPhase.getOrderNumber() == getPhases().length){
            this.currentPhase = getPhases()[0];
        }else{
            this.currentPhase = getPhases()[currentPhase.getOrderNumber()];
        }
    }
}
