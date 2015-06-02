package master.work.intersection.simulation.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by Oleksander.Dushyn on 5/10/2015.
 */
public class Constants {

    public static final long SIMULATION_DURATION_TIME = 5000;

    public static  long DEFAULT_PHASE_TIME = 15000;
    public static  double DEFAULT_TRAFFIC_AR = 0.1;
    public static  double DEFAULT_VEHICLE_LEAVING_RATE = 0.5;

    public static  double DEFAULT_LOW_TRAFFIC_BOTTOM_AR = 0.00;
    public static  double DEFAULT_LOW_TRAFFIC_TOP_AR = 0.10;

    public static  double DEFAULT_MID_TRAFFIC_BOTTOM_AR = 0.1;
    public static  double DEFAULT_MID_TRAFFIC_TOP_AR = 0.15;

    public static  double DEFAULT_HIGH_TRAFFIC_BOTTOM_AR = 0.15;
    public static  double DEFAULT_HIGH_TRAFFIC_TOP_AR = 0.16;

    public static  long DEFAULT_ARRIVALRATE_CHANGE_TIME = 45000;
}
