package master.work.intersection.simulation.fuzzy;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class FuzzyDecisionMaker {

    private static final String GREEN_VEHICLES = "green_vehicles";
    private static final String RED_VEHICLES = "red_vehicles";
    private static final String DELAY = "delay";

    private FIS controlRules;

    public FuzzyDecisionMaker(FIS controlRules) {

        this.controlRules = controlRules;
    }

    /**
     * Calculate the delay for the current green phase
     * @return delay time to continue current green phase in milliseconds
     */
    public long getTimeDelay(int waitingVehiclesOfNextGreenPhase, int waitingVehiclesOfCurrentGreenPhase){

        controlRules.setVariable(GREEN_VEHICLES, waitingVehiclesOfCurrentGreenPhase);
        controlRules.setVariable(RED_VEHICLES, waitingVehiclesOfNextGreenPhase);
        controlRules.evaluate();

        long delay = (long)(controlRules.getVariable(DELAY).getValue() * 1000);

/*        System.out.println("============================================");
        System.out.println("Vehicles of current green: " + waitingVehiclesOfCurrentGreenPhase);
        System.out.println("Vehicles of current red: " + waitingVehiclesOfNextGreenPhase);
        System.out.println("Delay: " + delay + " msec");
        System.out.println("============================================");*/
        return delay;
    }


}
