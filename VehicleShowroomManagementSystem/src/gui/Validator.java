/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * 
 */
public class Validator {

    public static boolean isEmpty(String text) {
        return text.trim().length() == 0;
    }

    // validate if text fields are empty
    public static boolean validateImage(JLabel lblPhoto) {
        if (lblPhoto.getIcon() == null) {
            new Message().error("Photo is required!");
            lblPhoto.setBackground(new Color(250, 255, 168));
            return false;
        }
        lblPhoto.setBackground(new Color(255, 255, 255));
        return true;
    }

    public static boolean validateNumber(JTextComponent[] component) {
        if (component != null) {
            for (int i = 0; i < component.length; i++) {
                component[i].setBackground(Color.white);
                if (!component[i].getText().matches("[\\d\\.]+")) {
                    new Message().error("Number is required here!");
                    component[i].setBackground(new Color(250, 255, 168));
                    component[i].requestFocus();
                    return false;
                }
                component[i].setBackground(new Color(255, 255, 255));
            }
        }
        return true;
    }

    public static boolean validateComponents(JTextComponent[] component) {
        if (component != null) {
            for (int i = 0; i < component.length; i++) {
                component[i].setBackground(Color.white);
                if (isEmpty(component[i].getText())) {
                    new Message().error("Empty value is not allowed here");
                    component[i].setBackground(new Color(250, 255, 168));
                    component[i].requestFocus();
                    return false;
                }
                component[i].setBackground(new Color(255, 255, 255));
            }
        }
        return true;
    }

    public static void setBlankFields(JTextComponent[] tcp) {
        for (int i = 0; i < tcp.length; i++) {
            tcp[i].setText("");
        }
    }

    // validate phone number
    public static boolean validatePhone(JTextField txtPhone) {
        if (!txtPhone.getText().matches("[\\d]{8,15}")) {
            new Message().error("Phone is not valid!");
            txtPhone.setBackground(new Color(250, 255, 168));
            txtPhone.requestFocus();
            return false;
        }
        txtPhone.setBackground(new Color(255, 255, 255));
        return true;
    }

    // validate email
    public static boolean validateEmail(JTextField txtEmail) {
        if (!txtEmail.getText().matches("^(([\\-\\w]+)\\.?)+@(([\\-\\w]+)\\.?)+\\.[a-zA-Z]{2,4}$")) {
            new Message().error("Email is not valid");
            txtEmail.setBackground(new Color(250, 255, 168));
            txtEmail.requestFocus();
            return false;
        }
        return true;
    }

    // validate float number
    public static boolean validateFloatField(JTextField txtNumber) {
        if (!txtNumber.getText().matches("[\\d]{1,3}(\\.[\\d]{1,5})?")) {
            new Message().error("Input is not valid float number");
            txtNumber.setBackground(new Color(250, 255, 168));
            txtNumber.requestFocus();
            return false;
        }
        txtNumber.setBackground(new Color(255, 255, 255));
        return true;
    }
}
