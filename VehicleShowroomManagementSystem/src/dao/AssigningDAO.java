/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Assigning;
import dto.Car;
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
public class AssigningDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Assigning");
            while (rs.next()) {
                Assigning as = new Assigning();
                as.setAssigningID(rs.getLong("AssigningID"));
                as.setOrderID(rs.getLong("OrderID"));
                as.setEmployeeID(rs.getLong("EmployeeID"));
                as.setOnAssigning(rs.getDate("OnAssigning"));
                list.add(as);
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
            cs = getConnect().prepareCall("{call searchAssigning(?)}");
            cs.setDate(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Assigning as = new Assigning();
                as.setAssigningID(rs.getLong("AssigningID"));
                as.setOrderID(rs.getLong("OrderID"));
                as.setEmployeeID(rs.getLong("EmployeeID"));
                as.setOnAssigning(rs.getDate("OnAssigning"));
                list.add(as);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(Assigning as) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertAssigning(?, ?, ?)}");
            cs.setLong(1, as.getOrderID());
            cs.setLong(2, as.getEmployeeID());
            cs.setDate(3, as.getOnAssigning());
            int row =  cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            return 0;
        }
    }

    public int update(Assigning as) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateAssigning(?, ?, ?)}");
            cs.setLong(1, as.getOrderID());
            cs.setDate(2, as.getOnAssigning());
            cs.setLong(3, as.getAssigningID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(long AssigningID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("delete from Assigning where AssigningID = (?)");
            pst.setLong(1, AssigningID);
            int row =  pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            return 0;
        }
    }

    public Assigning getAssigningByID(long AssigningID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getAssigningByID(?)}");
            cs.setLong(1, AssigningID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            Assigning as = new Assigning(rs.getLong("OrderID"), rs.getLong("AssigningID"), rs.getDate("OnAssigning"), rs.getLong("EmployeeID"));
            CloseConnection();
            return as;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
