/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PurchaseOrder;
import dto.PurchaseOrderDetails;
import gui.Message;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BINH
 */
public class PurchaseOrderDetailsDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PurchaseOrderDetails");
            while (rs.next()) {
                PurchaseOrderDetails pod = new PurchaseOrderDetails();
               pod.setCarNo(rs.getLong("CarNo"));
               pod.setPurchaseOrderID(rs.getLong("PurchaseOrderID"));
               pod.setQuantity(rs.getInt("Quantity"));
               pod.setPrice(rs.getFloat("Price"));
               list.add(pod);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(PurchaseOrderDetails pod) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertPurchaseOrderDetails(?, ?, ?, ?)}");
            cs.setLong(1, pod.getPurchaseOrderID());
            cs.setLong(2, pod.getCarNo());
            cs.setInt(3, pod.getQuantity());
            cs.setFloat(4, pod.getPrice());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        
    }

    public int update(PurchaseOrderDetails pod) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updatePurchaseOrderDetails(?, ?, ?, ?)}");
            cs.setInt(1, pod.getQuantity());
            cs.setFloat(2, pod.getPrice());
            cs.setLong(3, pod.getPurchaseOrderID());
            cs.setLong(4, pod.getCarNo());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int delete(long PurchaseOrderID, long CarNo) {
         CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call deletePurchaseOrderDetails(?, ?)}");
            cs.setLong(1, PurchaseOrderID);
            cs.setLong(2, CarNo);
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public PurchaseOrderDetails getPurchaseOrder(long PurchaseOrderID, long CarNo) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getPurchaseOrderDetails(?, ?)}");
            cs.setLong(1, PurchaseOrderID);
            cs.setLong(2, CarNo);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CloseConnection();
            return new PurchaseOrderDetails(rs.getLong("PurchaseOrderDetailsID"), rs.getLong("CarNo"), rs.getInt("Quantity"), rs.getFloat("Price"));
        } catch (Exception e) {
            return null;
        }
    }
    public boolean isExistCarNo(long PurchaseOrderID, long CarNo){
         CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistCarNoInPurchaseOrderDetails(?, ?)}");
            cs.setLong(1, PurchaseOrderID);
            cs.setLong(2, CarNo);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1)>0) {
                return true;
            }
            CloseConnection();
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
