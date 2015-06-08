package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class PretimedController extends Controller {

    private static final String NAME = "Pretimed";

    public PretimedController(Intersection intersection) {
        super(intersection);
        name = NAME;
    }

    @Override
    protected synchronized void regulate() throws InterruptedException {
        this.wait(intersection.getCurrentPhase().getPhaseTime());
        statistics.update();
        intersection.switchOnNextPhaseByDefault();
        //statistics.allPhasesStatistics();
    }

    @Override
    protected void specificSettings() {

    }

    @Override
    protected void wakeUp() throws InterruptedException {
        this.notify();
    }
}
