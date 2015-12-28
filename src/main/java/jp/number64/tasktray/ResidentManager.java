package jp.number64.tasktray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResidentManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResidentManager.class);

    public static void main(String[] args) {
        LOGGER.debug("Hello TaskTrayApplication!");

        TrayWorker worker = new TrayWorker();
        worker.doItYourself();
    }
}
