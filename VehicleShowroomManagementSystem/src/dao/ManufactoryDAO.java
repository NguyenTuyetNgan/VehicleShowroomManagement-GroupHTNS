/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Customer;
import dto.Manufactory;
import gui.Message;
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
public class ManufactoryDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Manufactory");
            while (rs.next()) {
                Manufactory mf = new Manufactory();
                mf.setManufactoryID(rs.getInt("ManufactoryID"));
                mf.setName(rs.getNString("ManufactoryName"));
                mf.setAddress(rs.getNString("Address"));
                mf.setPhone(rs.getInt("Phone"));
                mf.setLogo(rs.getBytes("Logo"));
                mf.setAddInfor(rs.getNString("AddInfor"));
                list.add(mf);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public ArrayList getList(String keyword) {
        CallableStatement cs;
        try {
            ArrayList list = new ArrayList();
            cs = getConnect().prepareCall("{call searchManufactory(?)}");
            cs.setNString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Manufactory mf = new Manufactory();
                mf.setManufactoryID(rs.getInt("ManufactoryID"));
                mf.setName(rs.getNString("ManufactoryName"));
                mf.setAddress(rs.getNString("Address"));
                mf.setPhone(rs.getInt("Phone"));
                mf.setLogo(rs.getBytes("Logo"));
                mf.setAddInfor(rs.getNString("AddInfor"));
                list.add(mf);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(Manufactory mf) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertManufactory(?, ?, ?, ?, ?)}");
            cs.setNString(1, mf.getName());
            cs.setString(2, mf.getAddress());
            cs.setInt(3, mf.getPhone());
            cs.setBytes(4, mf.getLogo());
            cs.setNString(5, mf.getAddInfor());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(Manufactory mf) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateManufactory(?, ?, ?, ?, ?, ?)}");
            cs.setNString(1, mf.getName());
            cs.setString(2, mf.getAddress());
            cs.setInt(3, mf.getPhone());
            cs.setBytes(4, mf.getLogo());
            cs.setNString(5, mf.getAddInfor());
            cs.setInt(6, mf.getManufactoryID());
            int result = cs.executeUpdate();
            CloseConnection();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(long ID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistManufactory(?)}");
            cs.setInt(1, (int) ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                Message.error("Can't delete data! \nThis Manufactory already exist in CarModel database");
                return 0;
            }
            PreparedStatement pst;
            pst = getConnect().prepareStatement("delete from Manufactory where ManufactoryID = (?)");
            pst.setLong(1, ID);
            int row = pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int getID(String Name) {
        CallableStatement cs;
        int ID = 0;
        try {
            cs = getConnect().prepareCall("{call getManufactoryByName(?)}");
            cs.setNString(1, Name);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CloseConnection();
            return rs.getInt("ManufactoryID");
        } catch (Exception ex) {
            return 0;
        }
    }

    public String getName(int ID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getManufactoryByID(?)}");
            cs.setInt(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CloseConnection();
            return rs.getNString("ManufactoryName");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public Manufactory getManufactory(int ID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("select * from Manufactory where  ManufactoryID = (?)");
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Manufactory mf = new Manufactory(rs.getInt("ManufactoryID"), rs.getInt("Phone"), rs.getNString("AddInfor"), rs.getNString("ManufactoryName"), rs.getNString("Address"), rs.getBytes("Logo"));
            CloseConnection();
            return mf;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
