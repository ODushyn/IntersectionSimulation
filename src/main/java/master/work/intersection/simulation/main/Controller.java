package master.work.intersection.simulation.main;

import master.work.intersection.simulation.statistics.Statistics;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    private static long START_TIME;
    protected String name;

    public static final int UNIT_OF_TIME = 1000;

    // General constants
    public static int SIMULATION_DURATION_TIME = 3600000;
    public static int PHASE_TIME = 20000;

    // Direction distribution constants
    public static double VEHICLE_ARRIVAL_RATE = 0.1;
    public static double VEHICLE_LEAVING_RATE = 0.5;

    protected Intersection intersection;
    protected Detector detector;
    protected Statistics statistics;

    public Controller(Intersection intersection) {
        this.intersection = intersection;
        this.detector = new Detector(intersection);
        this.statistics = new Statistics(intersection);
    }

    protected void launch(){
        System.out.println(name);
        START_TIME = Timer.currentTime();
        intersection.launchDirections();
        while(isOn()){
            regulate();
        }
        statistics.print();
    }

    protected abstract void regulate();
    //TODO: place to timer
    public static boolean isOn(){
        return (Timer.currentTime() - START_TIME) < SIMULATION_DURATION_TIME;
    }

    public String getName() {
        return name;
    }
}
