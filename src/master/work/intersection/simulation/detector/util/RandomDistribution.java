package master.work.intersection.simulation.detector.util;

import java.util.Random;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public class RandomDistribution extends Distribution{
    Random rand = new Random();

    @Override
    public int getNumberOfArrivedVehicles() {
        return rand.nextInt(2);
    }
}
