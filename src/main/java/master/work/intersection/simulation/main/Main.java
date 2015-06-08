package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.FuzzyDelayController;
import master.work.intersection.simulation.controller.FuzzyUrgencyAndDelayController;
import master.work.intersection.simulation.controller.PretimedController;
import master.work.intersection.simulation.intersec.test.HighTrafficIntersection;
import master.work.intersection.simulation.intersec.test.LowTrafficIntersection;
import master.work.intersection.simulation.intersec.test.MiddleTrafficIntersection;
import master.work.intersection.simulation.intersec.test.MixedTrafficIntersection;
import master.work.intersection.simulation.statistics.PlotStatisctics;
import master.work.intersection.simulation.util.Constants;
import org.apache.commons.math3.distribution.PoissonDistribution;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        //TODO: consider what parameters should be passed into Intersection
        //Intersection intersection = new FourWayIntersection(4, 12);

        List<Controller> controllers = new ArrayList<Controller>();

        //Phase 10 sec Fuzzy
        /*FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker3.fcl";
        Constants.DEFAULT_PHASE_TIME = 10000;
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic")  + " DecisionMaker3 - 2", 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic")  + " DecisionMaker3 - 2", 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic")  + " DecisionMaker3 - 2", 4, 12)));
        startControllers(controllers);
        controllers.clear();*/


        //Phase 10 sec Fuzzy
        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker3.fcl";
        FuzzyDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker3.fcl";
        Constants.DEFAULT_PHASE_TIME = 5000;
        controllers.add(new FuzzyDelayController(new LowTrafficIntersection(mode("Low Traffic")  + " DecisionMaker3 - 22", 4, 12)));
        //controllers.add(new FuzzyDelayController(new MiddleTrafficIntersection(mode("Middle Traffic")  + " DecisionMaker3 - 22", 4, 12)));
        //controllers.add(new FuzzyDelayController(new HighTrafficIntersection(mode("High Traffic")  + " DecisionMaker3 - 22", 4, 12)));
        startControllers(controllers);
        controllers.clear();

        //Phase 20 sec
        /*Constants.DEFAULT_PHASE_TIME = 15000;
        controllers.add(new PretimedController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new PretimedController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/

        //Phase 5 sec
/*        Constants.DEFAULT_PHASE_TIME = 20000;
        controllers.add(new PretimedController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new PretimedController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/


       /* FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker.fcl";
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();

        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker2.fcl";
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();

        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker3.fcl";
        Constants.DEFAULT_PHASE_TIME = 5000;
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic")  + " DecisionMaker3 - 2", 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic")  + " DecisionMaker3 - 2", 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic")  + " DecisionMaker3 - 2", 4, 12)));
        startControllers(controllers);
        controllers.clear();

        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker.fcl";
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        //start from here
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();

        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker2.fcl";
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/
        //Phase 10 sec Fuzzy
/*        Constants.DEFAULT_PHASE_TIME = 10000;
        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker3.fcl";
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic") + " DecisionMaker3 -2", 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic") + " DecisionMaker3 - 2", 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic") + " DecisionMaker3 - 2", 4, 12)));
        startControllers(controllers);
        controllers.clear();*/

/*        FuzzyUrgencyAndDelayController.DELAY_CONTROL_RULES_PATH = "fuzzy_control_rules/DecisionMaker.fcl";
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new FuzzyUrgencyAndDelayController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/
        //Phase 10 sec
/*        Constants.DEFAULT_PHASE_TIME = 10000;
        controllers.add(new FuzzyUrgencyAndDelayController(new LowTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new PretimedController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/
        //Phase 15 sec
/*        Constants.DEFAULT_PHASE_TIME = 15000;
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new PretimedController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/
        //Phase 20 sec
/*        Constants.DEFAULT_PHASE_TIME = 20000;
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Low Traffic"), 4, 12)));
        controllers.add(new PretimedController(new MiddleTrafficIntersection(mode("Middle Traffic"), 4, 12)));
        controllers.add(new PretimedController(new HighTrafficIntersection(mode("High Traffic"), 4, 12)));
        startControllers(controllers);
        controllers.clear();*/

        /*for(Controller contr: controllers){
            try {
                contr.launch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        try {
            PlotStatisctics.numOfVehiclesAndTime("Fuzzy Urgency And Delay 1432463.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
/*        try {
            testDistribution();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

    private static void startControllers(List<Controller> controllers){
        for(Controller contr: controllers){
            try {
                contr.launch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static String mode(String traffic){
        String phaseTime = "Phase time: " + Constants.DEFAULT_PHASE_TIME + ". ";
        if(traffic.equals("Low Traffic")){
            return "L" + phaseTime + "Low: " + Constants.DEFAULT_LOW_TRAFFIC_BOTTOM_AR + "-" + Constants.DEFAULT_LOW_TRAFFIC_TOP_AR;
        }
        if(traffic.equals("Middle Traffic")){
            return  "M" + phaseTime + "Middle: " + Constants.DEFAULT_MID_TRAFFIC_BOTTOM_AR + "-" + Constants.DEFAULT_MID_TRAFFIC_TOP_AR;
        }
        if(traffic.equals("High Traffic")){
            return "H" + phaseTime + "High: " + Constants.DEFAULT_HIGH_TRAFFIC_BOTTOM_AR + "-" + Constants.DEFAULT_HIGH_TRAFFIC_TOP_AR;
        }
        if(traffic.equals("Mixed Traffic")) {
            return "M" + phaseTime + "Mixed: " + Constants.DEFAULT_HIGH_TRAFFIC_BOTTOM_AR + "-" + Constants.DEFAULT_HIGH_TRAFFIC_TOP_AR;
        }
        return "";
    }
    private static void  testDistribution() throws InterruptedException {
        PoissonDistribution p = new PoissonDistribution(0.13);
        for(int i=0; i<10; i++){
            System.out.println(p.probability(i));
        }
        System.out.println(p.getMean() + " " + p.getNumericalMean() + "" +  p.getNumericalVariance());
        System.out.println(p.getSupportLowerBound() + " " + p.getSupportUpperBound());

        long lastDistributionTime = Timer.currentTime();
        List<Integer> list = new ArrayList();
        long start = Timer.currentTime();
        long duration = 3600000;
        while(Timer.currentTime() - start <  duration){

                System.out.println(p.sample());
                list.add(p.sample());
                lastDistributionTime = Timer.currentTime();

        }
        int sum = 0;
        for(Integer sample : list){
            sum+=sample;
        }

        System.out.println(sum + " " + list.size());
    }
}
