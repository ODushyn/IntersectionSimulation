package master.work.intersection.simulation.util;

import java.io.*;
import java.util.Properties;

/**
 * Created by Oleksander.Dushyn on 5/10/2015.
 */
public class Resources {

    private static Properties appProp = new Properties();
    private static InputStream input = null;
    private static final String APP_PROP_PATH = "app.properties";
    //TODO: DELETE this class???
    /*public Resources(){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(APP_PROP_PATH).getFile());

            input = new FileInputStream(file);

            appProp.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }*/

    private static Properties getAppProp() {
        return appProp;
    }
}
