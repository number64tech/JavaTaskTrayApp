package jp.number64.tasktray;

import java.awt.AWTException;
import java.awt.SystemTray;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResidentManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(ResidentManager.class);

    public static void main(String[] args) {
        LOGGER.debug("Hello TaskTrayApplication!");

        int exitCode = 0;
        try {
            // Set TaskTray Icon.
            AbstractTimerDrivenTrayObject timerDrivenTrayObject =
                new TimerDrivenTrayObjectBasic(Thread.currentThread());
            SystemTray.getSystemTray().add(timerDrivenTrayObject.getPreparedTrayIcon());

            Thread.sleep(20000);

        } catch (UnsupportedOperationException e) {
            LOGGER.debug("stacktrace: {}", e);
            exitCode = 11;
        } catch (IOException e) {
            LOGGER.debug("stacktrace: {}", e);
            exitCode = 12;
        } catch (AWTException e) {
            LOGGER.debug("stacktrace: {}", e);
            exitCode = 13;
        } catch (InterruptedException e) {
            LOGGER.debug("stacktrace: {}", e);
            exitCode = 14;
        }

        LOGGER.debug("end TaskTrayApplication EXITCODE:{}", exitCode);
        System.exit(exitCode);
    }
}
