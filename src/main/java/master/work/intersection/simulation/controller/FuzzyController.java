package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.fuzzy.FuzzyDecisionMaker;
import master.work.intersection.simulation.fuzzy.FuzzyUrgencyEvaluator;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Detector;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.statistics.Statistics;
import master.work.intersection.simulation.util.Decision;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyController extends Controller{

    protected Detector detector;
    private FuzzyDecisionMaker decisionMaker;
    private FuzzyUrgencyEvaluator urgencyEvaluator;
    private int nextPhase;
    private Decision decision;

    public FuzzyController(Intersection intersection) {
        super(intersection);
        //TODO: create objects FuzzyUrgencyEvaluator and FuzzyDecisionMaker
    }



    @Override
    protected void regulate() {
        if(intersection.greenPhaseTime() >= PHASE_TIME) {
            this.nextPhase = urgencyEvaluator.nextGreenPhase(detector.getDelayTimeOfRedPhase(), detector.getWaitingVehiclesOfRedPhase());
            this.decision = decisionMaker.getFinalDecision(nextPhase, detector.getWaitingVehiclesOfNextGreenPhase(), detector.getWaitingVehiclesOfCurrentGreenPhase());
            intersection.switchOnSpecifiedPhase(nextPhase);
            statistics.allPhasesStatistics();
        }
    }
}
