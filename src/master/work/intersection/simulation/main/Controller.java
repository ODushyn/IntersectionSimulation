package master.work.intersection.simulation.main;

import java.util.Calendar;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Controller {

    protected Intersection intersection;
    private long startTime = Calendar.getInstance().getTime().getTime();
    private int activeTime = 1000;

    protected abstract void launch();

    protected boolean isOn(){
        return (Calendar.getInstance().getTime().getTime() - startTime) < activeTime;

    }
}
