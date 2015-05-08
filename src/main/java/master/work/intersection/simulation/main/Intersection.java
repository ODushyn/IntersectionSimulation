package master.work.intersection.simulation.main;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Intersection {

    public static Distribution distribution;
    private Direction directions[];
    private Phase phases[];
    protected Phase currentPhase;

    public Intersection(Distribution distribution, int phases, int directions){
        this.distribution = distribution;
        initPhases(new Phase[phases]);
        initDirections(new Direction[directions]);
        init();
    }

    public void launchDirections(){
        for(Phase p : phases){
            for(Direction d: p.getDirections()){
                d.start();
            }
        }
    }

    protected abstract void init();

    public long greenPhaseTime(){
        return currentPhase.greenWaitingTime();
    }

    public void switchOnNextPhaseFromQueue(){
        this.currentPhase.deactivate();
        if(currentPhase.getNumber() == getPhases().length - 1){
            this.currentPhase = getPhases()[0];
        }else{
            this.currentPhase = getPhases()[currentPhase.getNumber() + 1];
        }
        this.currentPhase.activate();
        System.out.println("Next phase: " + currentPhase.getNumber());
    }

    public void switchOnSpecifiedPhase(int num){
        this.currentPhase.deactivate();
        this.currentPhase = getPhases()[num];
        this.currentPhase.activate();
        System.out.println("Next phase: " + currentPhase.getNumber());
    }

    private void initPhases(Phase phases[]){
        this.phases = phases;
        for(int i=0; i < this.phases.length; i++){
            this.phases[i] = new Phase(i);
        }
    }

    private void initDirections(Direction direction[]){
        this.directions = direction;
        for(int i=0; i < this.directions.length; i++){
            this.directions[i] = new Direction(i);
        }
    }

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
        this.currentPhase.activate();
    }

}
