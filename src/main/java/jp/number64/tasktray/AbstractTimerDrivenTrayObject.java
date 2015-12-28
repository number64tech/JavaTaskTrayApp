package jp.number64.tasktray;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public abstract class AbstractTimerDrivenTrayObject {

    // subclass only.
    long period = 2000;
    Timer timer;
    TimerTask worker;
    TrayIcon icon;
    PopupMenu menu;

    public AbstractTimerDrivenTrayObject(TimerTask worker, Thread thread) throws IOException {
        this.timer = new Timer();
        this.worker = worker;
        this.icon = new TrayIcon(ImageIO.read(ClassLoader.getSystemResourceAsStream(getIconResourceName())));
        this.menu = new PopupMenu();

        //
        icon.addActionListener(createIconClickActionListener());

        //
        MenuItem sampleItem = new MenuItem(getSampleItemLabel());
        sampleItem.addActionListener(createSampleActionListener());
        menu.add(sampleItem);

        //
        MenuItem timerStartItem = new MenuItem(getTimerStartItemLabel());
        timerStartItem.addActionListener(createTiemrStartActionListener());
        menu.add(timerStartItem);

        //
        MenuItem timetEndItem = new MenuItem(getTimerEndItemLabel());
        timetEndItem.addActionListener(createTiemrEndActionListener());
        menu.add(timetEndItem);

        //
        MenuItem exitItem = new MenuItem(getWakeTriggerItemLabel());
        exitItem.addActionListener(createWakeTriggerActionListener(thread));
        menu.add(exitItem);

        //
        icon.setPopupMenu(menu);
    }

    public TrayIcon getPreparedTrayIcon() {
        return icon;
    }

    public void setPeriodAsSec(long periodsec) {
        period = periodsec * 1000L;
    };

    abstract String getIconResourceName();

    public abstract void displayMessage(String caption, String message, TrayIcon.MessageType messageType);

    abstract ActionListener createIconClickActionListener();

    abstract String getSampleItemLabel();

    abstract ActionListener createSampleActionListener();

    abstract String getTimerStartItemLabel();

    abstract ActionListener createTiemrStartActionListener();

    abstract String getTimerEndItemLabel();

    abstract ActionListener createTiemrEndActionListener();

    abstract String getWakeTriggerItemLabel();

    abstract ActionListener createWakeTriggerActionListener(Thread thread);
}