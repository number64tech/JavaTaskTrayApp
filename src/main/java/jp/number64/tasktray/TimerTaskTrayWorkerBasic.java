package jp.number64.tasktray;

import java.awt.TrayIcon.MessageType;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerTaskTrayWorkerBasic extends TimerTask {
    private static Logger LOGGER = LoggerFactory.getLogger(TimerTaskTrayWorkerBasic.class);

    private AbstractTimerDrivenTrayObject trayObj;

    public void setTrayObject(AbstractTimerDrivenTrayObject trayObj) {
        this.trayObj = trayObj;
    }

    @Override
    public void run() {
        LOGGER.debug("TrayWorker#run()");
        trayObj.displayMessage("Timer", "called timertask.", MessageType.INFO);
    }
}
