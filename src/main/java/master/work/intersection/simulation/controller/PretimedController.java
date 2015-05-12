package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {

    private static final String NAME = "Pretimed Controller";

    public PretimedController(Intersection intersection) {
        super(intersection);
        name = NAME;
    }

    @Override
    protected void regulate() {
        if(intersection.getCurrentPhase().greenWaitingTime() >= intersection.getCurrentPhase().getPhaseTime()) {
            intersection.switchOnNextPhaseByDefault();
            statistics.update();
            //statistics.allPhasesStatistics();
        }
    }
}
