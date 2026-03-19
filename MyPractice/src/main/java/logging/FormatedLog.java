package logging;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormatedLog {
    private static final Logger log = LoggerFactory.getLogger(FormatedLog.class);

    static {
        BasicConfigurator.configure();
    }

    public static void main(String[] args) throws InterruptedException {
        log.error("Some text {}", "TEST-MESSAGE", new Exception("TEST-EXCEPTION"));
    }
}
