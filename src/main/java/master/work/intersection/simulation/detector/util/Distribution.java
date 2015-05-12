package master.work.intersection.simulation.detector.util;

/**
 * Created by Oleksander.Dushyn on 4/21/2015.
 */
public abstract class Distribution {

    private int totalNumberOfArrivedVehicles = 0;

    protected abstract int numberOfArrivedVehicles();

    public int arrivedVehicles(){
        int vehicles = numberOfArrivedVehicles();
        totalNumberOfArrivedVehicles += vehicles;
        return vehicles;
    }

    public int getTotalNumberOfArrivedVehicles() {
        return totalNumberOfArrivedVehicles;
    }

    public void setTotalNumberOfArrivedVehicles(int totalNumberOfArrivedVehicles) {
        this.totalNumberOfArrivedVehicles = totalNumberOfArrivedVehicles;
    }
}
