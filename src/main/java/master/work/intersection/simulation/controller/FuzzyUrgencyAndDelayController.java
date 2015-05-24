package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.fuzzy.FuzzyDecisionMaker;
import master.work.intersection.simulation.fuzzy.FuzzyUrgencyEvaluator;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import net.sourceforge.jFuzzyLogic.FIS;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyUrgencyAndDelayController extends Controller{

    private static final String NAME = "Fuzzy Urgency And Delay";
    public static String URGENCY_CONTROL_RULES_PATH = "fuzzy_control_rules/UrgencyEvaluator2.fcl";
    public static String DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker2.fcl";
    private static long DEFAULT_PHASE_TIME = 10000;

    private FuzzyDecisionMaker decisionMaker;
    private FuzzyUrgencyEvaluator urgencyEvaluator;
    private Phase nextPhase;
    private long delay;

    public FuzzyUrgencyAndDelayController(Intersection intersection) {
        super(intersection);
        try {
            urgencyEvaluator = new FuzzyUrgencyEvaluator(loadControlRule(URGENCY_CONTROL_RULES_PATH), intersection.getPhases().length);
            decisionMaker = new FuzzyDecisionMaker(loadControlRule(DELAY_CONTROL_RULES_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void specificSettings() {
        name = NAME;
        for(Phase p : intersection.getPhases()){
            p.setPhaseTime(DEFAULT_PHASE_TIME);
        }
    }

    @Override
    protected synchronized void regulate() throws InterruptedException {
        this.wait(intersection.getCurrentPhase().getPhaseTime());
        this.nextPhase = urgencyEvaluator.nextGreenPhase(intersection.redPhases());
        Phase curPhase = intersection.getCurrentPhase();
        System.out.println("====== Phase: " + curPhase.getNumber() + "==========");
        System.out.println("NumberVehiclesWaiting: " + curPhase.totalWaitingVehicles());
        System.out.println("TimeVehiclesWaiting: " + curPhase.redWaitingTime()/1000 + " sec.");
        System.out.println("Urgency: " + curPhase.getUrgency());
        System.out.println("================");
        this.delay = decisionMaker.getTimeDelay(nextPhase.averageWaitingVehiclesAtDirection(), intersection.getCurrentPhase().averageWaitingVehiclesAtDirection());
        System.out.println("Delay: " + delay);
        this.wait(delay);
        System.out.println("====== Phase After Delay: " + curPhase.getNumber() + "==========");
        System.out.println("NumberVehiclesWaiting: " + curPhase.totalWaitingVehicles());
        System.out.println("TimeVehiclesWaiting: " + curPhase.redWaitingTime()/1000 + " sec.");
        System.out.println("Urgency: " + curPhase.getUrgency());
        System.out.println("================");
        statistics.update();
        intersection.switchOnSpecifiedPhase(nextPhase);
    }

    private FIS loadControlRule(String fileName) throws FileNotFoundException {
        FIS fis = FIS.load(getPath(fileName), true);

        if( fis == null ) {
            throw new FileNotFoundException("Can't load file: '" + fileName + "'");
        }

        return fis;
    }

    private String getPath(String fileName) throws FileNotFoundException{
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(fileName);
        if(url == null){
            throw new FileNotFoundException("There is no file: '" + fileName + "'");
        }
        File file = new File(url.getFile());
        return file.getPath();
    }
}
