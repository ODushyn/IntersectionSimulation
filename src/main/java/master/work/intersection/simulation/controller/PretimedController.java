package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {


    public PretimedController(Intersection intersection) {
        super(intersection);
    }

    @Override
    protected void regulate() {
        if(intersection.getCurrentPhase().greenWaitingTime() >= PHASE_TIME) {
            intersection.switchOnNextPhaseByDefault();
            statistics.allPhasesStatistics();
        }
    }
}
