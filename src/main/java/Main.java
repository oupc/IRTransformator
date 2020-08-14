import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;
import utils.Config;
import utils.PropertiesKey;
import utils.ReadFile;
import utils.ReadLine;

public class Main {
    public static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ReadLine.readLine(args);
    }
}
