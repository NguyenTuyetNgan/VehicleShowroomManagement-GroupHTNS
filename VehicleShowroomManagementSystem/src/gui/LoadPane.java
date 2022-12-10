/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JPanel;

/**
 *
 * 
 */
public class LoadPane {
    public static void load(JPanel[] panelCompnent, JPanel panel){
        for (int i = 0; i < panelCompnent.length; i++) {
            panelCompnent[i].setVisible(false);
        }
        panel.setVisible(true);
    }
}
