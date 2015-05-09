package master.work.intersection.simulation.main;

import master.work.intersection.simulation.statistics.Statistics;

import java.util.Calendar;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    private static final long START_TIME = Controller.currentTime();
    public static final int UNIT_OF_TIME = 1000;

    // General constants
    public static int SIMULATION_DURATION_TIME = 900000;
    public static int PHASE_TIME = 15000;

    // Direction distribution constants
    public static double VEHICLE_ARRIVAL_RATE = 0.3;
    public static double VEHICLE_LEAVING_RATE = 1;

    protected Intersection intersection;
    protected Detector detector;
    protected Statistics statistics;

    public Controller(Intersection intersection) {
        this.intersection = intersection;
        this.detector = new Detector(intersection);
        this.statistics = new Statistics(intersection);
    }

    protected void launch(){
        intersection.launchDirections();
        while(isOn()){
            regulate();
        }
    }

    protected abstract void regulate();

    public static boolean isOn(){
        return (Controller.currentTime() - START_TIME) < SIMULATION_DURATION_TIME;
    }

    public synchronized static long currentTime(){
        return Calendar.getInstance().getTime().getTime();
    }

    public synchronized static boolean isTimeUp(long finishTime, long duration){
        return currentTime() - finishTime > duration;
    }

    public synchronized static boolean isTimeUp(long finishTime, long startTime, long duration){
        return finishTime - startTime > duration;
    }
}
