package master.work.intersection.simulation.detector.util;

import java.util.Random;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class RandomDistribute extends Distribution{

    private Random rand = new Random();
    private static int VEHICLES = 2;

    @Override
    protected int numberOfArrivedVehicles() {
        return rand.nextInt(VEHICLES);
    }
}
