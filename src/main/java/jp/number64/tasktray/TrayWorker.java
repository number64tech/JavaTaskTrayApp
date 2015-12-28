package jp.number64.tasktray;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrayWorker {
    private static Logger LOGGER = LoggerFactory.getLogger(TrayWorker.class);

    public void doItYourself() throws IOException, AWTException, UnsupportedOperationException {

        // タスクトレイアイコン
        Image image = ImageIO.read(
                getClass().getResourceAsStream("trayicon.png"));
        final TrayIcon icon = new TrayIcon(image);
        icon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                icon.displayMessage("アイコンクリック",
                    "アイコンがダブルクリックされました",
                    MessageType.WARNING);
            }
        });

        // ポップアップメニュー
        PopupMenu menu = new PopupMenu();
        // メニューの例
        MenuItem aItem = new MenuItem("メニューの例");
        aItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                icon.displayMessage("メニューの例",
                        "メニューが選択されました",
                        MessageType.ERROR);
            }
        });

        // 終了メニュー
        MenuItem exitItem = new MenuItem("終了");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // メニューにメニューアイテムを追加
        menu.add(aItem);
        menu.add(exitItem);
        icon.setPopupMenu(menu);

        // タスクトレイに格納
        SystemTray.getSystemTray().add(icon);

        //
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                icon.displayMessage("タイマー",
                        "タイマータスクです。", MessageType.INFO);
            }
        };

        LOGGER.debug("");

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1 * 60 * 1000); // 1分ごと
    }
}
