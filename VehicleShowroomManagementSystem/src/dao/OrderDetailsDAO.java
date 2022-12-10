/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.OrderDetails;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class OrderDetailsDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM OrderDetails");
            while (rs.next()) {
                OrderDetails od = new OrderDetails();
                od.setOrderID(rs.getLong("OrderID"));
                od.setCarNo(rs.getLong("CustomerID"));
                od.setQuantity(rs.getInt("Quantity"));
                list.add(od);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(OrderDetails od) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertOrderDetails(?, ?, ?)}");
            cs.setLong(1, od.getOrderID());
            cs.setLong(2, od.getCarNo());
            cs.setInt(3, od.getQuantity());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(OrderDetails od) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateOrderDetails(?, ?, ?) }");
            cs.setLong(1, od.getCarNo());
            cs.setInt(2, od.getQuantity());
            cs.setLong(3, od.getOrderID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(long ID, long CarNo) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call deleteOrderDetails(?, ?)} ");
            cs.setLong(1, ID);
            cs.setLong(2, CarNo);
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public boolean isExistCarNo(long OrderID, long CarNo){
         CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistCarNoInOrderDetails(?, ?)}");
            cs.setLong(1, OrderID);
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
