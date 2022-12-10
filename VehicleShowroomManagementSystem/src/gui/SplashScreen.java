/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.Connect;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * 
 */
public class SplashScreen extends JWindow {

    private int percent = 0; // indicates the status of progess bar
    private Timer t;
    private JProgressBar progessBar;
    private JLabel splashImage;
    private JLabel lb;

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        // Set the window's bounds, centering the window
        int width = 345;
        int height = 155;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        // Build the splash screen
        splashImage = new JLabel();
        splashImage.setIcon(new ImageIcon(getClass().getResource("/resources/splashScreen.jpg")));
        lb = new JLabel();
        lb.setForeground(new Color(120, 113, 113));
        lb.setHorizontalAlignment(SwingConstants.CENTER);
        lb.setText("Checking connection      ");
        progessBar = new javax.swing.JProgressBar();
        // create an action as param for Timer object
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                percent += (Math.random() * 10);
                if (percent > 10) {
                    lb.setText("Checking connection.     ");
                }
                if (percent > 20) {
                    lb.setText("Checking connection..    ");
                }
                if (percent > 30) {
                    lb.setText("Checking connection...   ");
                }
                if (percent > 50) {
                    try {
                        // keep showing Server Config dialog if connection to database fail
                        if (Connect.getConnect() != null) {
                            lb.setText("Checking connection... OK");
                        }
                    } catch (Exception ex) {
                        Message.error("Can't connect to database!\nPlease config database server");
                    }
                }
                if (percent >= 100) {
                    t.stop();
                    Media m = new Media("Windows XP Print complete.wav");
                    m.start();
                    progessBar.setValue(100);
                    dispose();
                    new LoginDialog(null, false);
                }
                progessBar.setValue(percent);
            }
        };
        // call action every 200 ms
        t = new Timer(200, action);
        progessBar.setValue(0);
        // timer starts
        t.start();
        content.add(splashImage, BorderLayout.CENTER);
        // create a panel to contain the label and the progess bar
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.add(lb, BorderLayout.PAGE_START);
        panel.add(progessBar, BorderLayout.PAGE_END);

        content.add(panel, BorderLayout.SOUTH);

        // Display it
        setVisible(true);
    }
}
