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
    private long lastDistributionTime;

    public Intersection(Distribution distribution, int phases, int directions){
        this.distribution = distribution;
        initPhases(new Phase[phases]);
        initDirections(new Direction[directions]);
    }

    protected abstract void init();

    public void simulateVehicleMoveAway(){
        for(Direction direction : currentPhase.getActiveDirections() ){
            direction.removeVehicleFromQueue();
        }
        this.lastVehicleRemoveTime = Controller.currentTime();
    }

    public void simulateDistribution(int time){
        if(Controller.currentTime() - lastDistributionTime > time) {
            for (Direction direction : directions) {
                direction.addVehiclesToQueue(distribution.getNumberOfArrivedVehicles());
                //System.out.println(direction.getName() + " : " + direction.getQueue());
            }
            lastDistributionTime = Controller.currentTime();
        }

    }

    public long greenPhaseTime(){
        return currentPhase.greenWaitingTime();
    }

    public long redPhaseTime(){
        return currentPhase.redWaitingTime();
    }

    public void switchOnNextPhaseFromQueue(){
        this.currentPhase.reset();
        if(currentPhase.getName() == getPhases().length - 1){
            this.currentPhase = getPhases()[0];
        }else{
            this.currentPhase = getPhases()[currentPhase.getName() + 1];
        }
        this.currentPhase.setUp();
        System.out.println("Next phase: " + currentPhase.getName());
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
        this.currentPhase.setUp();
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
    public long getLastDistributionTime() {
        return lastDistributionTime;
    }
    public void setLastDistributionTime(long lastDistributionTime) {
        this.lastDistributionTime = lastDistributionTime;
    }
}
