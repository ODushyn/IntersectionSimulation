package master.work.intersection.simulation.fuzzy;

import master.work.intersection.simulation.exception.NextPhaseNotSelectedException;
import master.work.intersection.simulation.intersec.util.Phase;
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.Variable;

import java.util.*;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyUrgencyEvaluator {

    private static final String VEHICLES = "vehicles";
    private static final String DURATION = "duration";
    private static final String URGENCY = "urgency";

    private FIS controlRules;
    private int numberOfPhases;
    private Stack<Phase> phaseCycle = new Stack<Phase>();
    private List<Phase> nextPhasesCandidates = new ArrayList<Phase>();

    public FuzzyUrgencyEvaluator(FIS controlRules, int numberOfPhases) {
        this.controlRules = controlRules;
        this.numberOfPhases = numberOfPhases;
    }

    /**
     * Calculates urgency and decide what phase is next
     * @return number of next phase
     */
    public Phase nextGreenPhase(Phase[] redPhases) {
        for(Phase redPhase : redPhases){
            controlRules.setVariable(VEHICLES, redPhase.waitingVehicles());
            controlRules.setVariable(DURATION, redPhase.redWaitingTime());
            controlRules.evaluate();
            Variable urgency = controlRules.getVariable(URGENCY);
            System.out.println("Urgency = " + urgency.getValue());
            redPhase.setUrgency(urgency.getValue());
            nextPhasesCandidates.add(redPhase);
        }
        Collections.sort(nextPhasesCandidates, new PhaseUrgencyComparator());

        return selectedNextPhaseAccordingToCycle(nextPhasesCandidates);
    }

    public Phase selectedNextPhaseAccordingToCycle(List<Phase> candidatePhases){
        for(Phase phase : candidatePhases ) {
            if (phaseCycle.search(phase) == -1) {
                phaseCycle.push(phase);
                if (phaseCycle.size() == numberOfPhases) {
                    phaseCycle.clear();
                }
                return phase;
            }
        }

        throw new NextPhaseNotSelectedException();
    }

    class PhaseUrgencyComparator implements Comparator<Phase> {
        @Override
        public int compare(Phase p1, Phase p2) {
            return p1.getUrgency() < p2.getUrgency() ? 1 : p1.getUrgency() == p2.getUrgency() ? 0 : -1;
        }
    }
}
