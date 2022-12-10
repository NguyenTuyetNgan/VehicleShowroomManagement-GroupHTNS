/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Car;
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
public class CarDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Car");
            while (rs.next()) {
                Car car = new Car();
                car.setCarNo(rs.getLong("CarNo"));
                car.setModelName(rs.getString("ModelName"));
                car.setName(rs.getString("Name"));
                car.setPrice(rs.getFloat("Price"));
                car.setStatus(rs.getBoolean("Status"));
                car.setAddInfor(rs.getNString("AddInfor"));
                list.add(car);
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
            cs = getConnect().prepareCall("{call searchCar(?)}");
            cs.setString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Car car = new Car();
                car.setCarNo(rs.getLong("CarNo"));
                car.setModelName(rs.getString("ModelName"));
                car.setName(rs.getString("Name"));
                car.setPrice(rs.getFloat("Price"));
                car.setStatus(rs.getBoolean("Status"));
                car.setAddInfor(rs.getNString("AddInfor"));
                list.add(car);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(Car car) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertCar(?, ?, ?, ?, ?)}");
            cs.setString(1, car.getModelName());
            cs.setString(2, car.getName());
            cs.setFloat(3, car.getPrice());
            cs.setNString(4, car.getAddInfor());
            cs.setBoolean(5, car.isStatus());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public int update(Car car) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateCar(?, ?, ?, ?, ?, ?)}");
            cs.setString(1, car.getModelName());
            cs.setString(2, car.getName());
            cs.setFloat(3, car.getPrice());
            cs.setNString(4, car.getAddInfor());
            cs.setBoolean(5, car.isStatus());
            cs.setLong(6, car.getCarNo());
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
            cs = getConnect().prepareCall("{call isExistCar(?)}");
            cs.setLong(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                PreparedStatement pst;
                pst = getConnect().prepareStatement("delete from Car where CarNo = (?)");
                pst.setLong(1, ID);
                int row = pst.executeUpdate();
                CloseConnection();
                return row;
            }
            Message.error("Can't delete CarNo: " + ID + " !\nThis CarNo currently exist in other database.");
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public Car getCar(long ID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("select * from Car where CarNo = (?)");
            pst.setLong(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Car car = new Car(rs.getLong("CarNo"), rs.getString("ModelName"), rs.getFloat("Price"), rs.getString("Name"), rs.getNString("AddInfor"), rs.getBoolean("Status"));
            return car;
        } catch (Exception ex) {
            return null;
        }
    }
}
