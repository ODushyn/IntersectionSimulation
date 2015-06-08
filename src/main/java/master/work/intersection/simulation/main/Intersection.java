package master.work.intersection.simulation.main;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Intersection {

    private Direction directions[];
    private String name;
    protected Phase phases[];
    protected Phase currentPhase;

    public Intersection(String name, int phases, int directions){
        this.name = name;
        this.phases = new Phase[phases];
        this.directions = new Direction[directions];
        createPhases();
        createDirections();
        init();
    }

    public void launchDirections(){
        startDirections();
    }

    protected abstract void init();

    public void switchOnNextPhaseByDefault(){
        Phase nextPhase;
        if(currentPhase.getNumber() == getPhases().length - 1){
            nextPhase = getPhases()[0];
        }else{
            nextPhase = getPhases()[currentPhase.getNumber() + 1];
        }
        showYellowLight(currentPhase, nextPhase);
        this.currentPhase.deactivate();
        showGreenLight(nextPhase, currentPhase);
        this.currentPhase = nextPhase;
        this.currentPhase.activate();

    }

    public void switchOnSpecifiedPhase(Phase nextPhase){
        showYellowLight(currentPhase, nextPhase);
        this.currentPhase.deactivate();
        showGreenLight(nextPhase, currentPhase);
        this.currentPhase = nextPhase;
        this.currentPhase.activate();
    }

    public Phase getNextPhaseByDefault(){
        if(currentPhase.getNumber() == getPhases().length - 1){
            return getPhases()[0];
        }
        return getPhases()[currentPhase.getNumber() + 1];
    }

    private synchronized void showYellowLight(Phase currentPhase, Phase nextPhase){
        currentPhase.light = TrafficLight.YELLOW;
        nextPhase.light = TrafficLight.YELLOW;
        for(Phase p : phases){
            System.out.println(p.getNumber() + ": " + p.light);
        }
        try {
            this.wait(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void showGreenLight(Phase nextPhase, Phase previousPhase){
        nextPhase.light = TrafficLight.GREEN;
        previousPhase.light = TrafficLight.RED;
        for(Phase p : phases){
            System.out.println(p.getNumber() + ": " + p.light);
        }
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

    protected void createPhases(){
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

    public void applyDefaultSetting(){
        notifyAllThreads();
        createPhases();
        createDirections();
        init();
    }

    public void notifyAllThreads(){
        for(Phase p : phases) {
            Direction directions[] = p.getDirections();
            for(Direction d : directions) {
                synchronized(d) {
                    d.notify();
                }
                synchronized(d.getArrivalRateObj()) {
                    d.getArrivalRateObj().notify();
                }
            }
        }
    }

    public void pauseAllDirections(){
        for(Phase p : phases) {
            Direction directions[] = p.getDirections();
            for(Direction d : directions) {
                synchronized(d) {
                    try {
                        d.wait(100000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized(d.getArrivalRateObj()) {
                    try {
                        d.getArrivalRateObj().wait(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void refreshPhaseTime(){
        for(Phase p : phases){
            p.refreshPhaseTime();
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
        this.currentPhase.light = TrafficLight.GREEN;
        this.currentPhase.activate();
        for(Phase p : phases){
            System.out.println(p.getNumber() + ": " + p.light);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
