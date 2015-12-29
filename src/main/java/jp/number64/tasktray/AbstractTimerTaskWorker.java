package jp.number64.tasktray;

import java.util.TimerTask;

public abstract class AbstractTimerTaskWorker extends TimerTask {

    AbstractTimerDrivenTrayObject trayObj;

    public AbstractTimerTaskWorker(AbstractTimerDrivenTrayObject trayObj) {
        this.trayObj = trayObj;
    };
}
