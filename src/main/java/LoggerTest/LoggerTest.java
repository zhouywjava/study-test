package LoggerTest;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by zhouyiwei on 2018/2/12.
 */
public class LoggerTest {

    private static final Logger logger = Logger.getLogger("LoggerTest");

    public static void main(String[] args) {
        logger.setLevel(Level.ALL);
        logger.info("你好 info");
        logger.warning(" hello warning ");
        logger.severe("hello severe");
        logger.fine("nihao fine");
        logger.config("nihao config");
    }
}
