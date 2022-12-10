/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.CarModel;
import dto.CarReceipt;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 *
 */
public class CarReceiptDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CarReceipt");
            while (rs.next()) {
                CarReceipt cr = new CarReceipt();
                cr.setReceiptID(rs.getLong("ReceiptID"));
                cr.setDate(rs.getDate("Date"));
                cr.setEmployeeID(rs.getLong("EmployeeID"));
                cr.setPurchaseOrderID(rs.getLong("PurchaseOrderID"));
                list.add(cr);
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
            cs = getConnect().prepareCall("{call searchReceipt(?)}");
            cs.setDate(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CarReceipt cr = new CarReceipt();
                cr.setReceiptID(rs.getLong("ReceiptID"));
                cr.setDate(rs.getDate("Date"));
                cr.setEmployeeID(rs.getLong("EmployeeID"));
                cr.setPurchaseOrderID(rs.getLong("PurchaseOrderID"));
                list.add(cr);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(CarReceipt cr) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertReceipt(?, ?, ?)}");
            cs.setDate(1, cr.getDate());
            cs.setLong(2, cr.getEmployeeID());
            cs.setLong(3, cr.getPurchaseOrderID());
            CloseConnection();
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(CarReceipt cr) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateReceipt(?, ?, ?, ?)}");
            cs.setDate(1, cr.getDate());
            cs.setLong(2, cr.getEmployeeID());
            cs.setLong(3, cr.getReceiptID());
            cs.setLong(4, cr.getPurchaseOrderID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Long ReceiptID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("delete from CarReceipt where ReceiptID = (?)");
            pst.setLong(1, ReceiptID);
            int row = pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public CarReceipt getCarReceipt(long ReceiptID, long PurchaseID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getReceipt(?, ?)}");
            cs.setLong(1, ReceiptID);
            cs.setLong(2, PurchaseID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CarReceipt cr = new CarReceipt(rs.getLong("ReceiptID"), rs.getLong("PurchaseOrderID"), rs.getLong("EmployeeID"), rs.getDate("Date"));
            CloseConnection();
            return cr;
        } catch (Exception ex) {
            return null;
        }
    }

    public CarReceipt getCarReceiptByID(long ReceiptID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getReceiptByID(?)}");
            cs.setLong(1, ReceiptID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CarReceipt cr = new CarReceipt(rs.getLong("ReceiptID"), rs.getLong("PurchaseOrderID"), rs.getLong("EmployeeID"), rs.getDate("Date"));
            CloseConnection();
            return cr;
        } catch (Exception ex) {
            return null;
        }
    }
}
