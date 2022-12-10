/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * 
 */
public class SelectFile {
    public static String selectImages(){
        JFileChooser jfc = new JFileChooser("C://");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images File", "png", "jpg", "jpeg", "gif", "tiff", "bmp");
        jfc.setFileFilter(filter);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int choice = jfc.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION){
            return jfc.getSelectedFile().toString();
        }
        return "";     
    }
}
