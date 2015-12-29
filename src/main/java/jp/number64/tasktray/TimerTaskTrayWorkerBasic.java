package jp.number64.tasktray;

import java.awt.TrayIcon.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerTaskTrayWorkerBasic extends AbstractTimerTaskWorker {
    private static Logger LOGGER = LoggerFactory.getLogger(TimerTaskTrayWorkerBasic.class);

    public TimerTaskTrayWorkerBasic(AbstractTimerDrivenTrayObject trayObj) {
        super(trayObj);
    }

    @Override
    public void run() {
        LOGGER.debug("TimerTaskTrayWorkerBasic#run()");
        trayObj.displayMessage("Timer", "called timertask.", MessageType.INFO);
    }
}
