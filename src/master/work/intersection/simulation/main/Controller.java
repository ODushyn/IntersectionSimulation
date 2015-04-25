package master.work.intersection.simulation.main;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.statistics.Statistics;

import java.util.Calendar;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {
    //TODO: replace this parameters
    private static final long startTime = Controller.currentTime();
    private int simulationTime = 10000;
    protected static int PHASE_TIME = 5000;

    protected Intersection intersection;
    protected Statistics statistics;

    public Controller(Intersection intersection, Statistics statistics) {
        this.intersection = intersection;
        this.statistics = statistics;
    }

    protected abstract void launch();

    protected boolean isOn(){
        return (Controller.currentTime() - startTime) < simulationTime;

    }

    public static long currentTime(){
        return Calendar.getInstance().getTime().getTime();
    }

}
