package jp.number64.tasktray;

import java.awt.AWTException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResidentManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResidentManager.class);

    public static void main(String[] args) {
        LOGGER.debug("Hello TaskTrayApplication!");

        TrayWorker worker = new TrayWorker();
        try {
            worker.doItYourself();
        } catch (UnsupportedOperationException e) {
            LOGGER.debug("stacktrace: {}", e);
        } catch (IOException e) {
            LOGGER.debug("stacktrace: {}", e);
        } catch (AWTException e) {
            LOGGER.debug("stacktrace: {}", e);
        }
    }
}
