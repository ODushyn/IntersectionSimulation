package master.work.intersection.simulation.detector.util;

import java.util.Random;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class RandomDistribution extends Distribution{

    private Random rand = new Random();
    private static int VEHICLES = 2;

    @Override
    public int getNumberOfArrivedVehicles() {
        return rand.nextInt(VEHICLES);
    }
}
