package master.work.intersection.simulation.main;

import master.work.intersection.simulation.controller.PretimedController;
import master.work.intersection.simulation.detector.util.Distribution;
import master.work.intersection.simulation.detector.util.RandomDistribution;
import master.work.intersection.simulation.intersec.FourWayIntersection;
import master.work.intersection.simulation.statistics.Statistics;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        Intersection intersection = new FourWayIntersection(4, 12);
        Distribution distribution = new RandomDistribution();

        Controller controller = new PretimedController(intersection, distribution, new Statistics(intersection));

        controller.launch();

    }
}
