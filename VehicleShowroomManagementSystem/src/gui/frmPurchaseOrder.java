/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bll.Manager;
import dao.CarDAO;
import dao.CustomerDAO;
import dao.EmployeeDAO;
import dao.PurchaseOrderDAO;
import dao.PurchaseOrderDetailsDAO;
import dto.Car;import dto.Customer;
import dto.Employee;
import dto.PurchaseOrder;
import dto.PurchaseOrderDetails;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.decorator.ColorHighlighter;
import org.jdesktop.swingx.decorator.HighlightPredicate;
import org.jdesktop.swingx.decorator.Highlighter;
import org.jdesktop.swingx.decorator.HighlighterFactory;

/**
 *
 *
 */
public class frmPurchaseOrder extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form frmOrder
     */
    public frmPurchaseOrder() {
        initComponents();
        new Utility().setIcon("/resources/order-17x20.gif", this, null);
        setLang(Main.baseName);
        loadEmptyTables();
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
        lblPurchaseOrderInformation = new javax.swing.JLabel();
        lblPurchaseID = new javax.swing.JLabel();
        lblPurchaseOrderID = new javax.swing.JLabel();
        lblOnOrder = new javax.swing.JLabel();
        dpkOrder = new org.jdesktop.swingx.JXDatePicker();
        lblEmpName = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPurchase = new org.jdesktop.swingx.JXTable();
        lblTotalPrices = new javax.swing.JLabel();
        lblTotalPrice = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnRemoveDelete = new javax.swing.JButton();
        lblEmployeeName = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        btnCar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Order Details");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(192, 192, 192)));

        lblPurchaseOrderInformation.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        lblPurchaseOrderInformation.setForeground(new java.awt.Color(0, 51, 255));
        lblPurchaseOrderInformation.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPurchaseOrderInformation.setText("PURCHASE ORDER INFORMATION");

        lblPurchaseID.setText("Purchase Order ID");

        lblOnOrder.setText("On Order");

        dpkOrder.setFormats("dd/MM/yyyy");
        Calendar cld = Calendar.getInstance();
        dpkOrder.setDate(cld.getTime());

        lblEmpName.setText("Employee Name");

        tblPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Highlighter simpleStripHL = HighlighterFactory.createSimpleStriping();
        tblPurchase.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW,
            null, new Color(0, 0, 255)));
    tblPurchase.setHighlighters(simpleStripHL);
    tblPurchase.addHighlighter(new ColorHighlighter(HighlightPredicate.ROLLOVER_ROW,
        null, new Color(255, 102, 0)));
tblPurchase.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        tblPurchaseMouseClicked(evt);
    }
    });
    jScrollPane2.setViewportView(tblPurchase);

    lblTotalPrices.setText("Total Price:");

    lblTotalPrice.setText("jLabel9");

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

    btnRemoveDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Erase-20.gif"))); // NOI18N
    btnRemoveDelete.setText("Remove");
    btnRemoveDelete.setActionCommand("remove");
    btnRemoveDelete.addActionListener(this);
    btnRemoveDelete.setEnabled(false);

    btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.gif"))); // NOI18N
    btnCancel.setText("Cancel");
    btnCancel.setActionCommand("cancel");
    btnCancel.addActionListener(this);

    btnAccept.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/OK-20.gif"))); // NOI18N
    btnAccept.setText("Accept");
    btnAccept.setActionCommand("add");
    btnAccept.addActionListener(this);
    btnAccept.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAcceptActionPerformed(evt);
        }
    });

    btnCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Taxi 20x20gif.gif"))); // NOI18N
    btnCar.setText("Car");
    btnCar.setActionCommand("car");
    btnCar.addActionListener(this);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(47, 47, 47)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblPurchaseID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblPurchaseOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblOnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(dpkOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(48, Short.MAX_VALUE))
        .addComponent(lblPurchaseOrderInformation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(btnCar)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveDelete)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(25, 25, 25))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 26, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(lblTotalPrices)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccept)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnCancel)
                    .addGap(30, 30, 30))))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblPurchaseOrderInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dpkOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblPurchaseOrderID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPurchaseID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(lblEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoveDelete)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPrices, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotalPrice))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(38, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addContainerGap())
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    setSize(new java.awt.Dimension(657, 572));
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblPurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPurchaseMouseClicked
        // TODO add your handling code here:

        btnRemoveDelete.setEnabled(true);

    }//GEN-LAST:event_tblPurchaseMouseClicked

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcceptActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPurchaseOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPurchaseOrder().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAccept;
    private javax.swing.JButton btnCancel;
    public javax.swing.JButton btnCar;
    public javax.swing.JButton btnRemoveDelete;
    public org.jdesktop.swingx.JXDatePicker dpkOrder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEmpName;
    public javax.swing.JLabel lblEmployeeName;
    private javax.swing.JLabel lblOnOrder;
    private javax.swing.JLabel lblPurchaseID;
    public javax.swing.JLabel lblPurchaseOrderID;
    private javax.swing.JLabel lblPurchaseOrderInformation;
    private javax.swing.JLabel lblTotalPrice;
    private javax.swing.JLabel lblTotalPrices;
    public static org.jdesktop.swingx.JXTable tblPurchase;
    // End of variables declaration//GEN-END:variables
    Employee emp;
    Customer c;

    public void setLang(String baseName) {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle(baseName, locale);
        lblPurchaseOrderInformation.setText(rb.getString("purchaseInfor"));
        lblPurchaseID.setText(rb.getString("purchaseID"));
        lblEmpName.setText(rb.getString("empName"));
        lblOnOrder.setText(rb.getString("onOrder"));
        lblTotalPrices.setText(rb.getString("totalPrice"));
        btnAccept.setText(rb.getString("accept"));
        btnCancel.setText(rb.getString("cancel"));
        btnRemoveDelete.setText(rb.getString("remove"));
        btnCar.setText(rb.getString("car"));
        JTableHeader th = tblPurchase.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue(rb.getString("carNo"));
        tc = tcm.getColumn(1);
        tc.setHeaderValue(rb.getString("name"));
        tc = tcm.getColumn(2);
        tc.setHeaderValue(rb.getString("modelName"));
        tc = tcm.getColumn(3);
        tc.setHeaderValue(rb.getString("quantity"));
//        tc = tcm.getColumn(4);
//        tc.setHeaderValue(rb.getString("price"));
        th.repaint();
    }

    public void loadDetailsTable(long ID) throws SQLException {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle(Main.baseName, locale);
        Vector vData = new Vector();
        Vector vColumn = new Vector();
        vColumn.removeAllElements();
        vColumn.add(rb.getString("carNo"));
        vColumn.add(rb.getString("name"));
        vColumn.add(rb.getString("modelName"));
        vColumn.add(rb.getString("quantity"));
        vColumn.add(rb.getString("price"));
        float totalPrice = 0;
        ResultSet rs = new Manager().getPurchaseOrderDetails(ID);
        while (rs.next()) {
            Vector vRow = new Vector();
            vRow.add(rs.getLong("CarNo"));
            vRow.add(rs.getString("Name"));
            vRow.add(rs.getString("ModelName"));
            vRow.add(rs.getInt("Quantity"));
            vRow.add(rs.getFloat("Price"));
            vData.add(vRow);
            totalPrice += (rs.getInt("Quantity") * rs.getFloat("Price"));
        }
        DefaultTableModel model = new DefaultTableModel(vData, vColumn);
        tblPurchase.setModel(model);
        lblTotalPrice.setText(totalPrice + "");
    }

    public static void setDetailsTable(long CarNo, int Quantity, float Price) {
        for (int i = 0; i < tblPurchase.getRowCount(); i++) {
            if (tblPurchase.getValueAt(i, 0).equals(CarNo)) {
                int quantity = (int) tblPurchase.getValueAt(i, 3);
                tblPurchase.setValueAt(quantity + Quantity, i, 3);
                tblPurchase.setValueAt(Price, i, 4);
                return;
            }
        }
        Vector v = new Vector();
        Car c = new CarDAO().getCar(CarNo);
        v.add(c.getCarNo());
        v.add(c.getName());
        v.add(c.getModelName());
        v.add(Quantity);
        v.add(Price);
        ((DefaultTableModel) tblPurchase.getModel()).addRow(v);

    }

    public void updateTotalPrice() {
        float totalPrice = 0;
        for (int i = 0; i < tblPurchase.getRowCount(); i++) {
            int Quantity = (int) tblPurchase.getValueAt(i, 3);
            float Price = (float) tblPurchase.getValueAt(i, 4);
            totalPrice += Quantity * Price;
        }
        lblTotalPrice.setText(totalPrice + "   ($)");
    }

    public void loadEmptyTables() {
        Locale locale = Locale.getDefault();
        ResourceBundle rb = ResourceBundle.getBundle(Main.baseName, locale);
        Vector vData = new Vector();
        Vector vColumn = new Vector();
        vColumn.removeAllElements();
        vColumn.add(rb.getString("carNo"));
        vColumn.add(rb.getString("name"));
        vColumn.add(rb.getString("modelName"));
        vColumn.add(rb.getString("quantity"));
        vColumn.add(rb.getString("price"));
        float totalPrice = 0;
        DefaultTableModel model = new DefaultTableModel(vData, vColumn);
        tblPurchase.setModel(model);
        lblTotalPrice.setText(totalPrice + "");
    }

    public void setValue() {
        lblPurchaseOrderID.setText(new Manager().getNewID("PurchaseOrder") + "");
        emp = new EmployeeDAO().getEmployee(Main.EmployeeID);
        lblEmployeeName.setText(emp.getFirstName() + " " + emp.getLastName());
        if (dlgCustomerList.CustomerID != 0) {
            c = new CustomerDAO().getCustomer(dlgCustomerList.CustomerID);
        }
    }

    public void addNewOrderDetails() {
        Manager mng = new Manager();
        PurchaseOrder pod = new PurchaseOrder(Long.parseLong(lblPurchaseOrderID.getText()), new Date(dpkOrder.getDate().getTime()), Main.EmployeeID);
        mng.addNew(pod, "purchase");
        long CarNo;
        int Quantity;
        float Price;
        for (int i = 0; i < tblPurchase.getRowCount(); i++) {
            CarNo = (long) tblPurchase.getValueAt(i, 0);
            Quantity = (int) tblPurchase.getValueAt(i, 3);
            Price = (float) tblPurchase.getValueAt(i, 4);
            PurchaseOrderDetails pods = new PurchaseOrderDetails(pod.getPurchaseOrderID(), CarNo, Quantity, Price);
            mng.addNew(pods, "purchaseDetails");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "cancel":
                dispose();
                break;
            case "remove":
                ((DefaultTableModel) tblPurchase.getModel()).removeRow(tblPurchase.getSelectedRow());
                updateTotalPrice();
                if (tblPurchase.getRowCount() == 0) {
                    btnRemoveDelete.setEnabled(false);
                }
                break;
            case "delete":
                int i = tblPurchase.getSelectedRow();
                if (i >= 0) {
                    long CarNo = (long) tblPurchase.getValueAt(i, 0);
                    new PurchaseOrderDetailsDAO().delete(Long.parseLong(lblPurchaseOrderID.getText()), CarNo);
                    ((DefaultTableModel) tblPurchase.getModel()).removeRow(i);
                    updateTotalPrice();
                }
                if (tblPurchase.getRowCount() == 0) {
                    btnRemoveDelete.setEnabled(false);
                }
                break;
            case "car":
                dlgCarList list = new dlgCarList(this, true);
                list.btnAdd.setActionCommand("addForPurchase");
                list.txtPrice.setEnabled(true);
                list.lblPrice.setEnabled(true);
                list.lbl$.setEnabled(true);
                list.setVisible(true);
                if (!list.isDisplayable()) {
                    updateTotalPrice();
                }
                break;
            case "add":
                if (tblPurchase.getRowCount() == 0) {
                    Message.error("Please choose atleast a car!");
                    btnCar.requestFocus();
                    return;
                }
                addNewOrderDetails();
                dispose();
                break;
            case "update":
                if (tblPurchase.getRowCount() == 0) {
                    Message.error("Please choose atleast a car!");
                    btnCar.requestFocus();
                    return;
                }
                PurchaseOrder po = new PurchaseOrder(Long.parseLong(lblPurchaseOrderID.getText()), new Date(dpkOrder.getDate().getTime()), Main.EmployeeID);
                new Manager().update(po, "purchase");
                for (int j = 0; j < tblPurchase.getRowCount(); j++) {
                    long CarNo = (long) tblPurchase.getValueAt(j, 0);
                    if (!new PurchaseOrderDetailsDAO().isExistCarNo(Long.parseLong(lblPurchaseOrderID.getText()), CarNo)) {
                        int Quantity = (int) tblPurchase.getValueAt(j, 3);
                        float Price = (float) tblPurchase.getValueAt(j, 4);
                        PurchaseOrderDetails pods = new PurchaseOrderDetails(Long.parseLong(lblPurchaseOrderID.getText()), CarNo, Quantity, Price);
                        new Manager().addNew(pods, "purchaseDetails");
                    }
                }
                dispose();
                break;
        }
    }
}
