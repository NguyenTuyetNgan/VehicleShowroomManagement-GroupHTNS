/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.Manager;
import dao.CarModelDAO;
import dao.ManufactoryDAO;
import dto.CarModel;
import dto.Manufactory;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.text.JTextComponent;

/**
 *
 *
 */
public class frmManufactory extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form frmManufactory
     */
    public frmManufactory() {
        initComponents();
        new Utility().setIcon("/resources/manufactory.gif", this, null);
        setLang(Main.baseName);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        pnlLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblAddInfor = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaAddInfor = new javax.swing.JTextArea();
        txtPhone = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        lblManufactory = new javax.swing.JLabel();
        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add new Manufactory");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setText("Name");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 88, 90, 18));

        lblPhone.setText("Phone");
        jPanel1.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, 21));

        lblAddress.setText("Address");
        jPanel1.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 50, 32));

        txaAddress.setColumns(20);
        txaAddress.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txaAddress.setRows(5);
        jScrollPane1.setViewportView(txaAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 270, -1));

        pnlLogo.setBackground(new java.awt.Color(255, 255, 255));
        pnlLogo.setBorder(javax.swing.BorderFactory.createTitledBorder("Logo"));
        pnlLogo.setLayout(new java.awt.BorderLayout());

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlLogo.add(lblLogo, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 170, 120));

        lblAddInfor.setText("Additional Information");
        jPanel1.add(lblAddInfor, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 300, 130, 27));

        txaAddInfor.setColumns(20);
        txaAddInfor.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txaAddInfor.setRows(5);
        jScrollPane2.setViewportView(txaAddInfor);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 333, 470, 90));
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 190, -1));
        jPanel1.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 86, 190, -1));

        btnBrowse.setText("Browse");
        btnBrowse.setActionCommand("browse");
        btnBrowse.addActionListener(this);
        jPanel1.add(btnBrowse, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        lblManufactory.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblManufactory.setForeground(new java.awt.Color(0, 51, 255));
        lblManufactory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblManufactory.setText("MANUFACTORY INFORMATION");
        jPanel1.add(lblManufactory, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 12, 610, 45));

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/OK-20.gif"))); // NOI18N
        btnAccept.setText("Accept");
        btnAccept.setActionCommand("add");
        btnAccept.addActionListener(this);
        jPanel1.add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, -1, -1));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.gif"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setActionCommand("cancel");
        btnCancel.addActionListener(this);
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 90, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(646, 532));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmManufactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmManufactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmManufactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmManufactory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmManufactory().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccept;
    public javax.swing.JButton btnBrowse;
    public javax.swing.JButton btnCancel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAddInfor;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblManufactory;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnlLogo;
    private javax.swing.JTextArea txaAddInfor;
    private javax.swing.JTextArea txaAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
    private static String path;
    private static byte[] tempImage;

    public void setLang(String baseName) {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle(baseName, locale);
        lblManufactory.setText(rb.getString("manufactoryInfor"));
        lblName.setText(rb.getString("manufactoryName"));
        lblPhone.setText(rb.getString("phone"));
        lblAddress.setText(rb.getString("address"));
        lblAddInfor.setText(rb.getString("addInfor"));
        btnBrowse.setText(rb.getString("browse"));
        btnAccept.setText(rb.getString("accept"));
        btnCancel.setText(rb.getString("cancel"));
    }

    public void loadData(int ID) {
        path = "";
        Manufactory mf = new ManufactoryDAO().getManufactory(ID);
        tempImage = mf.getLogo();
        txtName.setText(mf.getName());
        txtPhone.setText("0" + mf.getPhone());
        lblLogo.setIcon(new ImageIcon(mf.getLogo()));
        txaAddress.setText(mf.getAddress());
        txaAddInfor.setText(mf.getAddInfor());
    }

    public Manufactory getValue() {
        Manufactory mf = new Manufactory();
        mf.setManufactoryID(pnlCar.ManufactoryID);
        mf.setName(txtName.getText());
        mf.setPhone(Integer.parseInt(txtPhone.getText()));
        mf.setAddress(txaAddress.getText());
        mf.setAddInfor(txaAddInfor.getText());
        if (!path.equals("")) {
            try {
                File f = new File(path);
                FileInputStream in = new FileInputStream(f);
                byte[] photo = new byte[(int) f.length()];
                in.read(photo);
                mf.setLogo(photo);
            } catch (FileNotFoundException ex) {
                Message.error("Can't find file images!\nPlease try again.");
                return null;
            } catch (IOException ex) {
                Message.error("Can't read the file!\nPlease try again.");
                return null;
            }
        } else {
            mf.setLogo(tempImage);
        }
        return mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextComponent[] tcp = {txtName, txaAddress};
        switch (e.getActionCommand()) {
            case "add":
                if (!Validator.validateComponents(tcp) || !Validator.validatePhone(txtPhone) || !Validator.validateImage(lblLogo)) {
                    return;
                }
                new Manager().addNew(getValue(), "manufactory");
                this.dispose();
                break;
            case "update":
                if (!Validator.validateComponents(tcp) || !Validator.validatePhone(txtPhone) || !Validator.validateImage(lblLogo)) {
                    return;
                }
                new Manager().update(getValue(), "manufactory");
                this.dispose();
                break;
            case "cancel":
                this.dispose();
                break;
            case "browse":
                path = SelectFile.selectImages();
                if (!path.equals("")) {
                    lblLogo.setIcon(new ImageIcon(path));
                } else {
                    lblLogo.setIcon(null);
                }
                break;
        }
    }
}
