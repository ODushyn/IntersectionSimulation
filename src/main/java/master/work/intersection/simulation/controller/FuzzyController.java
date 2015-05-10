package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.fuzzy.FuzzyDecisionMaker;
import master.work.intersection.simulation.fuzzy.FuzzyUrgencyEvaluator;
import master.work.intersection.simulation.fuzzy.UrgencyEvaluatorInput;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import master.work.intersection.simulation.util.Decision;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyController extends Controller{

    private FuzzyDecisionMaker decisionMaker;
    private FuzzyUrgencyEvaluator urgencyEvaluator;
    private Phase nextPhase;
    private Decision decision;

    public FuzzyController(Intersection intersection) {
        super(intersection);
        urgencyEvaluator = new FuzzyUrgencyEvaluator(intersection.getPhases().length);
        decisionMaker = new FuzzyDecisionMaker();
    }



    @Override
    protected void regulate() {
        if(intersection.getCurrentPhase().greenWaitingTime() >= PHASE_TIME) {
            this.nextPhase = urgencyEvaluator.nextGreenPhase(generateUEInput(), intersection.getCurrentPhase());
            this.decision = decisionMaker.getFinalDecision(nextPhase, nextPhase.waitingVehicles(), intersection.getCurrentPhase().waitingVehicles());
            intersection.switchOnSpecifiedPhase(nextPhase);
            statistics.allPhasesStatistics();
        }
    }

    private List<UrgencyEvaluatorInput> generateUEInput(){
        List<UrgencyEvaluatorInput> inputList = new ArrayList<UrgencyEvaluatorInput>();

        for(Phase phase : intersection.redPhases()){
            UrgencyEvaluatorInput input = new UrgencyEvaluatorInput();
            input.setPhaseNumber(phase.getNumber());
            input.setDelayTimeOfRedPhase(phase.redWaitingTime());
            input.setWaitingVehiclesOfRedPhase(phase.waitingVehicles());
        }

        return inputList;
    }
}
