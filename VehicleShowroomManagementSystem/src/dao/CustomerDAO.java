/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Customer;
import gui.Message;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 *
 */
public class CustomerDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from Customer");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getLong("CustomerID"));
                customer.setFirstName(rs.getNString("FirstName"));
                customer.setLastName(rs.getNString("LastName"));
                customer.setSex(rs.getBoolean("Sex"));
                customer.setDateOfBirth(rs.getDate("DateOfBirth"));
                customer.setAddress(rs.getNString("Address"));
                customer.setPhone(rs.getInt("phone"));
                list.add(customer);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList getList(String keyword) {
        CallableStatement cs;
        try {
            ArrayList list = new ArrayList();
            cs = getConnect().prepareCall("{call searchCustomer(?)}");
            cs.setNString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getLong("CustomerID"));
                customer.setFirstName(rs.getNString("FirstName"));
                customer.setLastName(rs.getNString("LastName"));
                customer.setSex(rs.getBoolean("Sex"));
                customer.setDateOfBirth(rs.getDate("DateOfBirth"));
                customer.setAddress(rs.getNString("Address"));
                customer.setPhone(rs.getInt("Phone"));
                list.add(customer);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(Customer customer) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertCustomer(?, ?, ?, ?, ?, ?)}");
            cs.setNString(1, customer.getFirstName());
            cs.setNString(2, customer.getLastName());
            cs.setBoolean(3, customer.isSex());
            cs.setDate(4, customer.getDateOfBirth());
            cs.setNString(5, customer.getAddress());
            cs.setInt(6, customer.getPhone());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(Customer customer) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateCustomer(?, ?, ?, ?, ?, ?, ?)}");
            cs.setNString(1, customer.getFirstName());
            cs.setNString(2, customer.getLastName());
            cs.setBoolean(3, customer.isSex());
            cs.setDate(4, customer.getDateOfBirth());
            cs.setNString(5, customer.getAddress());
            cs.setInt(6, customer.getPhone());
            cs.setLong(7, customer.getCustomerID());
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
            cs = getConnect().prepareCall("{call isExistCustomer(?)}");
            cs.setLong(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                cs = getConnect().prepareCall("{call deleteCustomer(?)}");
                cs.setLong(1, ID);
                int row = cs.executeUpdate();
                CloseConnection();
                return row;
            }
            Message.error("Can't delete data!\nThis Customer currently exist in other database.");
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public Customer getCustomer(long ID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getCustomerByID(?)}");
            cs.setLong(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            Customer c = new Customer(rs.getLong("CustomerID"), rs.getNString("FirstName"), rs.getNString("LastName"),
                    rs.getNString("Address"), rs.getDate("DateOfBirth"), rs.getInt("Phone"), rs.getBoolean("Sex"));
            CloseConnection();
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
