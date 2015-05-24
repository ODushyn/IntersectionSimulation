package master.work.intersection.simulation.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by Oleksander.Dushyn on 5/10/2015.
 */
public class Constants {

    public static final long SIMULATION_DURATION_TIME = 20000;

    public static final long DEFAULT_PHASE_TIME = 10000;
    public static final double DEFAULT_TRAFFIC_AR = 0.1;
    public static final double DEFAULT_VEHICLE_LEAVING_RATE = 0.5;

    public static final double DEFAULT_LOW_TRAFFIC_BOTTOM_AR = 0.07000;
    public static final double DEFAULT_LOW_TRAFFIC_TOP_AR = 0.09000;

    public static final double DEFAULT_MID_TRAFFIC_BOTTOM_AR = 0.09;
    public static final double DEFAULT_MID_TRAFFIC_TOP_AR = 0.11;

    public static final double DEFAULT_HIGH_TRAFFIC_BOTTOM_AR = 0.11;
    public static final double DEFAULT_HIGH_TRAFFIC_TOP_AR = 0.13;

    public static final long DEFAULT_ARRIVALRATE_CHANGE_TIME = 45000;
}
