package master.work.intersection.simulation.main;

import master.work.intersection.simulation.statistics.Statistics;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    public static long START_TIME;
    protected String name;

    public static final int UNIT_OF_TIME = 1000;

    // General constants
    public static int SIMULATION_DURATION_TIME = 1800000;

    // Direction distribution constants
    public static double DEFAULT_VEHICLE_ARRIVAL_RATE = 0.3;
    public static double DEFAULT_VEHICLE_LEAVING_RATE = 0.5;

    protected Intersection intersection;
    protected Statistics statistics;

    public Controller(Intersection intersection) {
        //TODO: check initialization to make controller launch after finishing again
        // without creating new controller.
        this.intersection = intersection;
        this.statistics = new Statistics(intersection);
    }

    public void launch() throws InterruptedException{
            System.out.println(name);
            START_TIME = Timer.currentTime();
            intersection.launchDirections();
            while(isOn()){
                    regulate();
            }
            intersection.applyDefaultSetting();
            statistics.print();
    }

    protected abstract void regulate() throws InterruptedException;
    //TODO: place to timer
    public static boolean isOn(){
        return (Timer.currentTime() - START_TIME) < SIMULATION_DURATION_TIME;
    }

    public String getName() {
        return name;
    }

    public static long getStartTime() {
        return START_TIME;
    }
}
