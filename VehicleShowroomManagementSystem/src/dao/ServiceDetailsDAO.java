/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.ServiceDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class ServiceDetailsDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ServiceDetails");
            while (rs.next()) {
                ServiceDetails sd = new ServiceDetails();
                sd.setServiceID(rs.getInt("ServiceID"));
                sd.setCarNo(rs.getLong("CarNo"));
                list.add(sd);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int addNew(ServiceDetails sd) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("insert into ServiceDetails (ServiceID, CarNo) values(?, ?) ");
            pst.setInt(1, sd.getServiceID());
            pst.setLong(2, sd.getCarNo());
            int row = pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int[] getID(Vector v) {
        int[] ID = new int[v.size()];
        try {
            for (int i = 0; i < v.size(); i++) {
                PreparedStatement pst = getConnect().prepareStatement("select ID from Service where Name like '" + v.get(i) + "'");
                ResultSet rs = pst.executeQuery();
                ID[i] = rs.getInt("ID");
            }
            return ID;
        } catch (Exception e) {
            return null;
        }
    }

    public String[] getServiceName(long CarNo) {
        try {
            PreparedStatement pst = getConnect().prepareStatement("select Service.Name from Car inner join "
                    + "ServiceDetails on Car.CarNo = ServiceDetails.CarNo inner join Service on ServiceDetails.ServiceID"
                    + " = Service.ServiceID"
                    + " where Car.CarNo = " + CarNo);
            ResultSet rs = pst.executeQuery();
            ArrayList list = new ArrayList();

            while (rs.next()) {
                list.add(rs.getNString(1));
            }
            String[] arrStr = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                arrStr[i] = list.get(i).toString();
            }
            CloseConnection();
            return arrStr;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int delete(long CarNo) {
        try {
            PreparedStatement pst;
            pst = getConnect().prepareStatement("delete from ServiceDetails where CarNo = " + CarNo);
            int row = pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            return 0;
        }
    }
}
