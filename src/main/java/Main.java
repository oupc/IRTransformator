import JDT.Parser;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;
import transfor.Transformator;
import utils.Config;
import utils.PropertiesKey;
import utils.ReadFile;
import utils.ReadLine;

@Log4j2
public class Main {

    public static void main(String[] args) {
        ReadLine.readLine(args);

        Parser.parser();
        log.info("complete create ASTs");

        Transformator.trans();
    }
}
