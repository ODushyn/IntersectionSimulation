package master.work.intersection.simulation.exception;

/**
 * Created by Oleksander.Dushyn on 5/11/2015.
 */
public class NextPhaseNotSelectedException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Not able to select next phase";
    }
}
