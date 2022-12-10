/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Service;
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
public class ServiceDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Service");
            while (rs.next()) {
                Service service = new Service();
                service.setServiceID(rs.getInt("ServiceID"));
                service.setName(rs.getNString("Name"));
                service.setDescription(rs.getNString("Description"));
                list.add(service);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(Service service) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertService(?, ?)}");
            cs.setNString(1, service.getName());
            cs.setNString(2, service.getDescription());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(Service service) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateService(?, ?, ?)}");
            cs.setNString(1, service.getName());
            cs.setNString(2, service.getDescription());
            cs.setInt(3, service.getServiceID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int delete(int ServiceID) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistService(?)}");
            cs.setInt(1, ServiceID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                Message.error("Can't delete data " + ServiceID + "!\n This ID already exist in ServiceDetails database.");
                return 0;
            }
            cs = getConnect().prepareCall("{call deleteService(?)}");
            cs.setInt(1, ServiceID);
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public Service getService(int ID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("select * from Service where ServiceID = (?)");
            pst.setInt(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Service s = new Service(rs.getInt("ServiceID"), rs.getNString("Name"), rs.getNString("Description"));
            CloseConnection();
            return s;
        } catch (Exception ex) {
            return null;
        }
    }

    public int getID(String Name) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getServiceIDByName(?)}");
            cs.setNString(1, Name);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CloseConnection();
            return rs.getInt("ServiceID");
        } catch (Exception ex) {
            return 0;
        }
    }
}
