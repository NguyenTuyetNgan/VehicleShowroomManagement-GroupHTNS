/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.Connect;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Image;
import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.util.FileResolver;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * 
 */
public class Utility {

    public void setIcon(String src, Frame frm, Dialog dlg) {
        if (frm != null) {
            Image icon = frm.getToolkit().getImage(getClass().getResource(src));
            frm.setIconImage(icon);
            return;
        }
        Image icon = dlg.getToolkit().getImage(getClass().getResource(src));
        dlg.setIconImage(icon);
    }

    public void getReport(String fileName) {
        try {
            String reportName = "report/" + fileName + ".jasper";
            HashMap map = new HashMap();
            InputStream is = this.getClass().getClassLoader().getResourceAsStream(reportName);
            JasperPrint jasperPrint = JasperFillManager.fillReport(is, map, Connect.getConnect());
            //     JasperExportManager.exportReportToHtmlFile(jasperPrint, "huy.html"); 

            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
    }

    public void getReportWithParam(String fileName, String ID) throws Exception {
        try {
            Map<String, Object> parameters = null;
            InputStream input = null;


            String reportName = "report/" + fileName + ".jasper";
            FileResolver fileResolver = new FileResolver() {
                @Override
                public File resolveFile(String fileName) {
                    URI uri;
                    try {
                        uri = new URI(this.getClass().getResource(fileName).getPath());
                        return new File(uri.getPath());
                    } catch (URISyntaxException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        return null;
                    }
                }
            };

            parameters = new HashMap<>();
            parameters.put("REPORT_FILE_RESOLVER", fileResolver);
            if (fileName.equals("PurchaseOrder")) {
                parameters.put("purchaseOrderID", ID);
            } else if (fileName.equals("Order")) {
                parameters.put("orderID", ID);
            }

            input = this.getClass().getClassLoader().getResourceAsStream(reportName);

            //DBTool tool = new DBTool();

            JasperPrint print = JasperFillManager.fillReport(input, parameters, Connect.getConnect());
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    public void disableButton(JButton[] arrButton){
        for (int i = 0; i < arrButton.length; i++) {
            arrButton[i].setVisible(false);
        }
    }
    public static void updateLookAndFeel(String LF, Frame frm){
        try {
            UIManager.setLookAndFeel(LF);
            SwingUtilities.updateComponentTreeUI(frm);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Utility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    public static byte[] encrypt (SecretKey key, String str) throws Exception{
//        Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
//        cipher.init(Cipher.ENCRYPT_MODE, key);
//        return cipher.doFinal(str.getBytes());
//    }
//     public static String decrypt (SecretKey key, byte[] encryptByte) throws Exception{
//        Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
//        cipher.init(Cipher.DECRYPT_MODE, key);
//        String recover  = new String(cipher.doFinal(encryptByte));
//        return recover;
//    }
}
