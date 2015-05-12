package master.work.intersection.simulation.main;

import java.util.Calendar;

/**
 * Created by Oleksander.Dushyn on 5/11/2015.
 */
public class Timer {

    public synchronized static boolean repeat(long finishTime, long duration){
        return currentTime() - finishTime > duration;
    }

    public synchronized static boolean repeat(long finishTime, long startTime, long duration){
        return finishTime - startTime > duration;
    }

    public synchronized static long currentTime(){
        return Calendar.getInstance().getTime().getTime();
    }
}
