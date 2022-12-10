/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class Message {

    public static void error(String s) {
        new Media(new File("Windows XP Error.wav").getAbsolutePath()).start();
        JOptionPane.showMessageDialog(null, s, "Error!", JOptionPane.ERROR_MESSAGE);
    }

    public static void infor(String s) {
        new Media(new File("Windows XP Print complete.wav").getAbsolutePath()).start();
        JOptionPane.showMessageDialog(null, s, "Information!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(String s) {
        new Media(new File("Windows XP Exclamation.wav").getAbsolutePath()).start();
        int i = JOptionPane.showConfirmDialog(null, s, "Confirmation", JOptionPane.YES_NO_OPTION);
        if (i == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
}
