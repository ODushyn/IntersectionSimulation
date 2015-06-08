package master.work.intersection.simulation.controller;

import master.work.intersection.simulation.fuzzy.FuzzyDecisionMaker;
import master.work.intersection.simulation.intersec.util.Phase;
import master.work.intersection.simulation.main.Controller;
import master.work.intersection.simulation.main.Intersection;
import net.sourceforge.jFuzzyLogic.FIS;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

/**
 * Created by Oleksander.Dushyn on 6/1/2015.
 */
public class FuzzyDelayController extends Controller {
    private static final String NAME = "Fuzzy Delay";
   // public static String DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker.fcl";
   public static String DELAY_CONTROL_RULES_PATH;
    private static long DEFAULT_PHASE_TIME = 10000;

    private FuzzyDecisionMaker decisionMaker;
    private Phase nextPhase;
    private long delay;

    public FuzzyDelayController(Intersection intersection) {
        super(intersection);
        name = NAME;
        try {
            decisionMaker = new FuzzyDecisionMaker(loadControlRule(DELAY_CONTROL_RULES_PATH));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void specificSettings() {
        /*name = NAME;
        for(Phase p : intersection.getPhases()){
            p.setPhaseTime(DEFAULT_PHASE_TIME);
        }*/
    }

    @Override
    protected synchronized void wakeUp() throws InterruptedException {
        synchronized (this) {
            System.out.println("here");
            this.notify();
        }
    }

    @Override
    protected synchronized void regulate() throws InterruptedException {
        System.out.println(intersection.getCurrentPhase().getPhaseTime() + "dddddd");
        this.wait(intersection.getCurrentPhase().getPhaseTime());
        this.nextPhase = intersection.getNextPhaseByDefault();
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
