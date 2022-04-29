package com.mantou.time;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RemindMe {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //每天18:00执行,每隔一分钟执行一次
    @Scheduled(cron = "0 0/1 18 * * ?")
    public void testTasks2() {
        int res = JOptionPane.showConfirmDialog(null, "是否继续操作", "是否继续", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            System.out.println("选择是后执行的代码"); // 点击“是”后执行这个代码块
        } else {
            System.out.println("选择否后执行的代码"); // 点击“否”后执行这个代码块
            return;
        }
        System.out.println("定时任务执行时间1：" + dateFormat.format(new Date()));
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);
            trayIcon.displayMessage("下班提醒","记得打卡!",TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        System.out.println("定时任务执行时间：" + dateFormat.format(new Date()));
    }
}
