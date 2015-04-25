package master.work.intersection.simulation.main;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.statistics.Statistics;

import java.util.Calendar;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    protected Intersection intersection;
    protected Distribution distribution;
    protected Statistics statistics;
    private long startTime = currentTime();
    private int simulationTime = 10000;
    protected static int PHASE_TIME = 5000;

    protected abstract void launch();

    public Controller(Intersection intersection, Distribution distribution, Statistics statistics) {
        this.intersection = intersection;
        this.distribution = distribution;
        this.statistics = statistics;
    }

    protected boolean isOn(){
        return (Calendar.getInstance().getTime().getTime() - startTime) < simulationTime;

    }

    protected long currentTime(){

        return Calendar.getInstance().getTime().getTime();
    }
}
