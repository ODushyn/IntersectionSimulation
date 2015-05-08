package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.statistics.Statistics;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {


    public PretimedController(Intersection intersection) {
        super(intersection);
    }

    @Override
    protected void regulate() {
        if(intersection.greenPhaseTime() >= PHASE_TIME) {
            intersection.switchOnNextPhaseFromQueue();
            statistics.allPhasesStatistics();
        }
    }
}
