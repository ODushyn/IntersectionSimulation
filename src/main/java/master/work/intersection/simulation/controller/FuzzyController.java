package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.fuzzy.FuzzyDecisionMaker;
import master.work.intersection.simulation.fuzzy.FuzzyUrgencyEvaluator;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Detector;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.statistics.Statistics;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyController extends Controller{

    protected Detector detector;
    private FuzzyDecisionMaker decisionMaker;
    private FuzzyUrgencyEvaluator urgencyEvaluator;

    public FuzzyController(Intersection intersection) {
        super(intersection);
    }

    @Override
    protected void regulate() {

    }
}
