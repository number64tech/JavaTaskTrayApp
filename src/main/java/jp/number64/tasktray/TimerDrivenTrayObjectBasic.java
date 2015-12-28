package jp.number64.tasktray;

import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimerDrivenTrayObjectBasic extends AbstractTimerDrivenTrayObject {
    private static Logger LOGGER = LoggerFactory.getLogger(TimerDrivenTrayObjectBasic.class);

    public TimerDrivenTrayObjectBasic(TimerTask worker, Thread thread) throws IOException {
        super(worker, thread);
    }

    @Override
    public void displayMessage(String caption, String message,TrayIcon.MessageType messageType) {
        this.icon.displayMessage(caption, message, messageType );
    }

    @Override
    public String getIconResourceName() {
        return "icon.png";
    }

    @Override
    ActionListener createIconClickActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.debug("TrayIcon:actionPerformed(ActionEvent e)");
                icon.displayMessage("IconClick", "IconClick, twice.", MessageType.INFO);
            }
        };
    }

    @Override
    String getSampleItemLabel() {
        return "sample.";
    }

    @Override
    ActionListener createSampleActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.debug("sampleAction:actionPerformed(ActionEvent e)");
                icon.displayMessage("sample", "sampleEvent.", MessageType.ERROR);
            }
        };
    }

    @Override
    String getTimerStartItemLabel() {
        return "TimerStart";
    }

    @Override
    ActionListener createTiemrStartActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.debug("TimerStartAction:actionPerformed(ActionEvent e)");
                timer.cancel();
                timer = new Timer();
                timer.scheduleAtFixedRate(worker, 0, period);
            }
        };
    }

    @Override
    String getTimerEndItemLabel() {
        return "TimerEnd";
    }

    @Override
    ActionListener createTiemrEndActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.debug("TimerEndAction:actionPerformed(ActionEvent e)");
                timer.cancel();
            }
        };
    }

    @Override
    String getWakeTriggerItemLabel() {
        return "AppEnd";
    }

    @Override
    ActionListener createWakeTriggerActionListener(Thread thread) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LOGGER.debug("WakeTriggerAction:actionPerformed(ActionEvent e)");
                thread.interrupt();
            }
        };
    }
}
