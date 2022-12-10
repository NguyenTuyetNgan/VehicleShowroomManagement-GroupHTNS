/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.Manager;
import dao.CustomerDAO;
import dto.Customer;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.text.JTextComponent;

/**
 *
 * 
 */
public class frmCustomer extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form frmCustomer
     */
    public frmCustomer() {
        initComponents();
        new Utility().setIcon("/resources/customer.gif", this, null);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblFirstName = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        lblLastName = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        rbnMale = new javax.swing.JRadioButton();
        rbnFemale = new javax.swing.JRadioButton();
        lblDateOfBirth = new javax.swing.JLabel();
        dpkBirthday = new org.jdesktop.swingx.JXDatePicker();
        lblAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaAddress = new javax.swing.JTextArea();
        btnAccept = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblCustomerInformation = new javax.swing.JLabel();
        lblCustID = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Customer");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFirstName.setText("First Name");
        jPanel1.add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 125, -1, -1));
        jPanel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 122, 97, -1));

        lblLastName.setText("Last Name");
        jPanel1.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 125, -1, -1));
        jPanel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(333, 122, 131, -1));

        lblSex.setText("Sex");
        jPanel1.add(lblSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 220, -1, -1));

        rbnMale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbnMale);
        rbnMale.setSelected(true);
        rbnMale.setText("Male");
        jPanel1.add(rbnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        rbnFemale.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rbnFemale);
        rbnFemale.setText("Female");
        jPanel1.add(rbnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, -1));

        lblDateOfBirth.setText("Date of Birth");
        jPanel1.add(lblDateOfBirth, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 174, -1, -1));

        dpkBirthday.setFormats("dd/MM/yyyy");
        Calendar cld = Calendar.getInstance();
        dpkBirthday.setDate(cld.getTime());
        jPanel1.add(dpkBirthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 128, -1));

        lblAddress.setText("Address");
        jPanel1.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 314, -1, -1));

        txaAddress.setColumns(20);
        txaAddress.setRows(5);
        jScrollPane1.setViewportView(txaAddress);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 314, 320, 69));

        btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/OK-20.gif"))); // NOI18N
        btnAccept.setText("Accept");
        btnAccept.setActionCommand("add");
        btnAccept.addActionListener(this);
        jPanel1.add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 410, -1, -1));

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.gif"))); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setActionCommand("cancel");
        btnCancel.addActionListener(this);
        jPanel1.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 410, -1, -1));

        lblPhone.setText("Phone");
        jPanel1.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 263, -1, -1));
        jPanel1.add(txtPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 267, 128, -1));

        lblCustomerInformation.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblCustomerInformation.setForeground(new java.awt.Color(0, 51, 255));
        lblCustomerInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomerInformation.setText("CUSTOMER INFORMATION");
        jPanel1.add(lblCustomerInformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 12, 495, 42));

        lblCustID.setText("Customer ID");
        jPanel1.add(lblCustID, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 84, -1, -1));

        lblCustomerID.setText("Auto Creation");
        jPanel1.add(lblCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 84, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(533, 518));
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
            java.util.logging.Logger.getLogger(frmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCustomer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private org.jdesktop.swingx.JXDatePicker dpkBirthday;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCustID;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblCustomerInformation;
    private javax.swing.JLabel lblDateOfBirth;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSex;
    private javax.swing.JRadioButton rbnFemale;
    private javax.swing.JRadioButton rbnMale;
    private javax.swing.JTextArea txaAddress;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables

    public void setLang(String baseName) {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle(baseName, locale);
        lblCustomerInformation.setText(rb.getString("custInfor"));
        lblPhone.setText(rb.getString("phone"));
        lblCustID.setText(rb.getString("custID"));
        lblFirstName.setText(rb.getString("firstName"));
        lblLastName.setText(rb.getString("lastName"));
        lblDateOfBirth.setText(rb.getString("dateOfBirth"));
        lblSex.setText(rb.getString("sex"));
        rbnMale.setText(rb.getString("male"));
        rbnFemale.setText(rb.getString("female"));
        lblAddress.setText(rb.getString("address"));
        btnAccept.setText(rb.getString("accept"));
        btnCancel.setText(rb.getString("cancel"));
    }

    public void loadEmptyForm() {
        lblCustomerID.setText(new Manager().getNewID("Customer") + "");
        txtFirstName.setText("");
        txtLastName.setText("");
        Calendar c = Calendar.getInstance();
        dpkBirthday.setDate(c.getTime());
        txtPhone.setText("");
        txaAddress.setText("");
    }

    public void setValues(long CustomerID) {
        Customer c = new CustomerDAO().getCustomer(CustomerID);
        lblCustomerID.setText(c.getCustomerID() + "");
        txtFirstName.setText(c.getFirstName());
        txtLastName.setText(c.getLastName());
        dpkBirthday.setDate(c.getDateOfBirth());
        boolean sex = c.isSex();
        if (!sex) {
            rbnFemale.setSelected(true);
        }
        txtPhone.setText("0" + c.getPhone());
        txaAddress.setText(c.getAddress());
    }

    public Customer getCustomer() {
        long CustomerID = 0;
        if (!lblCustomerID.getText().equals("Auto Creation")) {
            CustomerID = Long.parseLong(lblCustomerID.getText());
        }
        boolean sex = true;
        if (rbnFemale.isSelected()) {
            sex = false;
        }
        return new Customer(CustomerID, txtFirstName.getText(), txtLastName.getText(), txaAddress.getText(), new Date(dpkBirthday.getDate().getTime()), Integer.parseInt(txtPhone.getText()), sex);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextComponent[] tcp = {txtFirstName, txtLastName, txaAddress};
        switch (e.getActionCommand()) {
            case "add":
                if (Validator.validateComponents(tcp) && Validator.validatePhone(txtPhone)) {
                    new Manager().addNew(getCustomer(), "customer");
                    dispose();
                }
                break;
            case "update":
                if (Validator.validateComponents(tcp) && Validator.validatePhone(txtPhone)) {
                    new Manager().update(getCustomer(), "customer");
                    dispose();
                }
                break;
            case "cancel":
                dispose();
                break;
        }
    }
}
