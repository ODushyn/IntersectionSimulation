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
        this.phases = new Phase[phases];
        this.directions = new Direction[directions];
    }

    public void launchDirections(){
        this.distribution.setTotalNumberOfArrivedVehicles(0);
        createPhases();
        createDirections();
        init();
        startDirections();
    }

    protected abstract void init();

    public void switchOnNextPhaseByDefault(){
        this.currentPhase.deactivate();
        if(currentPhase.getNumber() == getPhases().length - 1){
            this.currentPhase = getPhases()[0];
        }else{
            this.currentPhase = getPhases()[currentPhase.getNumber() + 1];
        }
        this.currentPhase.activate();
/*        System.out.println("Next phase: " + currentPhase.getNumber());*/
    }

    public void switchOnSpecifiedPhase(Phase phase){
        this.currentPhase.deactivate();
        this.currentPhase = phase;
        this.currentPhase.activate();
/*        System.out.println("Next phase: " + currentPhase.getNumber());
        System.out.println("NumberWaitingVehicles: " + currentPhase.waitingVehicles());
        System.out.println("==================================================");*/
    }

    public Phase[] redPhases(){
        Phase[] redPhases = new Phase[this.phases.length - 1];
        int i = 0;
        for(Phase p : this.phases){
            if(p != currentPhase){
                redPhases[i] = p;
                i++;
            }
        }
        return redPhases;
    }
    private void createPhases(){
        for(int i=0; i < this.phases.length; i++){
            this.phases[i] = new Phase(i);
        }
    }

    private void createDirections(){
        for(int i=0; i < this.directions.length; i++){
            this.directions[i] = new Direction(i);
        }
    }

    private void startDirections(){
        for(Phase p : phases){
            for(Direction d: p.getDirections()){
                d.start();
            }
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
