/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Manufactory;
import dto.Order;
import gui.Message;
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
public class OrderDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM [Order]");
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getLong("OrderID"));
                order.setCustomerID(rs.getLong("CustomerID"));
                order.setOnOrder(rs.getDate("OnOrder"));
                order.setEmployeeID(rs.getLong("EmployeeID"));
                order.setRequest(rs.getNString("Request"));
                order.setConfirmation(rs.getBoolean("Confirmation"));
                list.add(order);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList getList(Date keyword) {
        CallableStatement cs;
        try {
            ArrayList list = new ArrayList();
            cs = getConnect().prepareCall("{call searchOrder(?)}");
            cs.setDate(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderID(rs.getLong("OrderID"));
                order.setCustomerID(rs.getLong("CustomerID"));
                order.setOnOrder(rs.getDate("OnOrder"));
                order.setEmployeeID(rs.getLong("EmployeeID"));
                order.setRequest(rs.getNString("Request"));
                order.setConfirmation(rs.getBoolean("Confirmation"));
                list.add(order);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int addNew(Order order) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertOrder(?, ?, ?, ?, ?)}");
            cs.setLong(1, order.getCustomerID());
            cs.setDate(2, order.getOnOrder());
            cs.setLong(3, order.getEmployeeID());
            cs.setNString(4, order.getRequest());
            cs.setBoolean(5, order.isConfirmation());

            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(Order order) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateOrder(?, ?, ?, ?)}");
            cs.setDate(1, order.getOnOrder());
            cs.setNString(2, order.getRequest());
            cs.setBoolean(3, order.isConfirmation());
            cs.setLong(4, order.getOrderID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int delete(long ID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistOrder(?)}");
            cs.setLong(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                new Message().error("Can't delete data!\n This Order are existed in the other database.");
                return 0;
            }
            PreparedStatement pst;
            pst = getConnect().prepareStatement("delete from [Order] where OrderID = (?)");
            pst.setLong(1, ID);
            int row = pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public Order getOrder(long ID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("select * from [Order] where OrderID = (?)");
            pst.setLong(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Order order = new Order(rs.getLong("OrderID"), rs.getLong("CustomerID"), rs.getDate("OnOrder"),
                    rs.getBoolean("Confirmation"), rs.getNString("Request"), rs.getLong("EmployeeID"));
            CloseConnection();
            return order;
        } catch (Exception ex) {
            return null;
        }
    }

    public int countOrder() {
        Statement st;
        try {
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("select count(*) from [Order]");
            rs.next();
            int i = rs.getInt(1);
            CloseConnection();
            return i;
        } catch (Exception ex) {
            return 0;
        }
    }

    public float getTotalPrice(long OrderID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call totalOrderPrice(?)}");
            cs.setLong(1, OrderID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            float f = rs.getFloat(1);
            CloseConnection();
            return f;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }
}
