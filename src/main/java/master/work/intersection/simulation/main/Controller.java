package master.work.intersection.simulation.main;

import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.statistics.Statistics;
import master.work.intersection.simulation.util.Constants;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    private static long startTime;
    //TODO: move values to constants
    private static long simulationDurationTime = Constants.SIMULATION_DURATION_TIME;
    protected String name;

    public static final int UNIT_OF_TIME = 1000;

    // General constants


    // Direction distribution constants
    public static double DEFAULT_VEHICLE_ARRIVAL_RATE = 0.3;
    public static double DEFAULT_VEHICLE_LEAVING_RATE = 0.5;

    protected Intersection intersection;
    protected Statistics statistics;

    public Controller(Intersection intersection) {
        //TODO: check initialization to make controller launch after finishing again
        // without creating new controller.
        this.intersection = intersection;
    }

    public void launch() throws InterruptedException{
            System.out.println(name);
            startTime = Timer.currentTime();
            statistics = new Statistics(this);
            intersection.launchDirections();
            while(isOn()){
                    regulate();
            }
            statistics.print1();
            statistics.saveToFile();
            intersection.applyDefaultSetting();

    }

    protected  abstract void regulate() throws InterruptedException;

    public static boolean isOn(){
        return (Timer.currentTime() - startTime) < simulationDurationTime;
    }

    public String getName() {
        return name;
    }

    public long getStartTime() {
        return startTime;
    }

    public Intersection getIntersection() {
        return intersection;
    }

    public void setIntersection(Intersection intersection) {
        this.intersection = intersection;
    }

    public long getSimulationDurationTime() {
        return simulationDurationTime;
    }

    public void setSimulationDurationTime(int simulationDurationTime) {
        this.simulationDurationTime = simulationDurationTime;
    }
}
