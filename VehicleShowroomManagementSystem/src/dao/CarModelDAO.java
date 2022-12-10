/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Assigning;
import dto.CarModel;
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
 *
 */
public class CarModelDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM CarModel");
            while (rs.next()) {
                CarModel cm = new CarModel();
                cm.setModelName(rs.getString("ModelName"));
                cm.setAddInfor(rs.getNString("AddInfor"));
                cm.setImage(rs.getBytes("Image"));
                cm.setManufactoryID(rs.getInt("ManufactoryID"));
                list.add(cm);
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
            cs = getConnect().prepareCall("{call searchModel(?)}");
            cs.setString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                CarModel cm = new CarModel();
                cm.setModelName(rs.getString("ModelName"));
                cm.setAddInfor(rs.getNString("AddInfor"));
                cm.setImage(rs.getBytes("Image"));
                cm.setManufactoryID(rs.getInt("ManufactoryID"));
                list.add(cm);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int addNew(CarModel cm) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertModel(?, ?, ?, ?)} ");
            cs.setString(1, cm.getModelName());
            cs.setNString(2, cm.getAddInfor());
            cs.setBytes(3, cm.getImage());
            cs.setInt(4, cm.getManufactoryID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(CarModel cm) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateModel(?, ?, ?, ?)} ");
            cs.setNString(1, cm.getAddInfor());
            cs.setBytes(2, cm.getImage());
            cs.setInt(3, cm.getManufactoryID());
            cs.setString(4, cm.getModelName());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(String ModelName) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistModel(?)}");
            cs.setString(1, ModelName);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                cs = getConnect().prepareCall("{call deleteModel(?)}");
                cs.setString(1, ModelName);
                int row = cs.executeUpdate();
                CloseConnection();
                return row;
            }
            Message.error("Can't delete Car No data: " + ModelName + " !\nThis CarNo data currently exist in other database.");
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public CarModel getCarModel(String Name) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getModelByName(?)}");
            cs.setString(1, Name);
            ResultSet rs = cs.executeQuery();
            rs.next();
            CarModel cm = new CarModel(rs.getBytes("Image"), rs.getString("ModelName"), rs.getString("AddInfor"), rs.getInt("ManufactoryID"));
            CloseConnection();
            return cm;
        } catch (Exception ex) {
            return null;
        }
    }
}
