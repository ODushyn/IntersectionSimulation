package master.work.intersection.simulation.main;

import master.work.intersection.simulation.intersec.util.Direction;
import master.work.intersection.simulation.intersec.util.Phase;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class Intersection {

    private Detector detector;
    private Direction directions[];
    private Phase phases[];
    private Phase currentPhase;

    public Intersection(int phases, int directions){
        this.phases = new Phase[phases];
        this.directions = new Direction[directions];
    }
}
