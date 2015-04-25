package master.work.intersection.simulation.main;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Intersection {

    private Distribution distribution;
    private Direction directions[];
    private Phase phases[];
    protected Phase currentPhase;

    //TODO: change this parameter with multi threads
    private long lastVehicleRemoveTime;

    public Intersection(int phases, int directions){
        initPhases(new Phase[phases]);
        initDirections(new Direction[directions]);
    }

    protected abstract void init();

    public void simulateVehicleMoveAway(){
        for(Direction direction : currentPhase.getActiveDirections() ){
            direction.removeVehicleFromQueue();
        }
    }

    public void simulateDistribution(){
        for(Direction direction : directions){
            direction.addVehiclesToQueue(distribution.getNumberOfArrivedVehicles());
        }

    }

    public void switchOnNextPhaseFromQueue(){
        if(currentPhase.getPhaseName() == getPhases().length){
            this.currentPhase = getPhases()[0];
        }else{
            this.currentPhase = getPhases()[currentPhase.getPhaseName()];
        }
        System.out.println(currentPhase.getPhaseName());
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
    }

    public Direction[] getDirections() {
        return directions;
    }

    public long getLastVehicleRemoveTime() {
        return lastVehicleRemoveTime;
    }

    public void setLastVehicleRemoveTime(long lastVehicleRemoveTime) {
        this.lastVehicleRemoveTime = lastVehicleRemoveTime;
    }
}
