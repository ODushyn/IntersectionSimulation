package master.work.intersection.simulation.main;

import master.work.intersection.simulation.detector.util.Distribution;

import java.util.Calendar;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    protected Intersection intersection;
    protected TrafficLight trafficLight;
    protected Distribution distribution;
    private long startTime = currentTime();
    private int simulationTime = 4000;
    protected static int PHASE_TIME = 2000;

    protected abstract void launch();

    protected boolean isOn(){
        return (Calendar.getInstance().getTime().getTime() - startTime) < simulationTime;

    }

    protected long currentTime(){
        return Calendar.getInstance().getTime().getTime();
    }
}
