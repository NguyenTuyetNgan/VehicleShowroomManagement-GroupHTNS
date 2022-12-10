/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Order;
import dto.PurchaseOrder;
import gui.Message;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author BINH
 */
public class PurchaseOrderDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM PurchaseOrder");
            while (rs.next()) {
                PurchaseOrder po = new PurchaseOrder();
                po.setPurchaseOrderID(rs.getLong("PurchaseOrderID"));
                po.setDate(rs.getDate("Date"));
                po.setEmployeeID(rs.getLong("EmployeeID"));
                list.add(po);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
    public ArrayList getList(Date keyword) {
        CallableStatement cs;
        try {
            ArrayList list = new ArrayList();
            cs = getConnect().prepareCall("{call searchPurchaseOrder(?)}");
            cs.setDate(1, keyword);
            ResultSet rs = cs.executeQuery();
             while (rs.next()) {
                PurchaseOrder po = new PurchaseOrder();
                po.setPurchaseOrderID(rs.getLong("PurchaseOrderID"));
                po.setDate(rs.getDate("Date"));
                po.setEmployeeID(rs.getLong("EmployeeID"));
                list.add(po);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
    public int addNew(PurchaseOrder po) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertPurchaseOrder(?, ?)}");
            cs.setDate(1, po.getDate());
            cs.setLong(2, po.getEmployeeID());
            CloseConnection();
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public int update(PurchaseOrder po) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updatePurchaseOrder(?, ?)}");
            cs.setDate(1, po.getDate());
            cs.setLong(2, po.getPurchaseOrderID());
            CloseConnection();
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(long ID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistPurchaseOrder(?)}");
            cs.setLong(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                new Message().error("Can't delete data!\nThis Purchase order are existed in other database! ");
                return 0;
            }
            PreparedStatement pst;
            pst = getConnect().prepareStatement("delete from PurchaseOrder where PurchaseOrderID = (?)");
            pst.setLong(1, ID);
            int row = pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public PurchaseOrder getPurchaseOrder(long ID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("select * from PurchaseOrder where PurchaseOrderID = (?)");
            pst.setLong(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            PurchaseOrder po = new PurchaseOrder(rs.getLong("PurchaseOrderID"), rs.getDate("Date"), rs.getLong("EmployeeID"));
            CloseConnection();
            return po;
        } catch (Exception ex) {
            return null;
        }
    }
    public long countPurchaseOrder(){
         Statement st;
        try {
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("select top 1* from [PurchaseOrder] order by PurchaseOrderID desc");
            rs.next();
            CloseConnection();
            return rs.getLong("PurchaseOrderID");
        } catch (Exception ex) {
             return 0;
        }
    }
    public float getTotalPrice(long PurchaseOrderID){
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call totalPurchaseOrderPrice(?)}");
            cs.setLong(1, PurchaseOrderID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CloseConnection();
            return rs.getFloat(1);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
