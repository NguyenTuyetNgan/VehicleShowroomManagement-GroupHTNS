/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Department;
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
public class DepartmentDAO extends Connect {
    
    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Department");
            while (rs.next()) {
                Department department = new Department();
                department.setDepartmentName(rs.getNString("DepartmentName"));
                list.add(department);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public int addNew(Department department) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistDepartmentName(?)}");
            cs.setNString(1, department.getDepartmentName());
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) != 0) {
                Message.error("Can't add " + department.getDepartmentName() + "!\n This name is duplicated.");
                return 0;
            }
            cs = getConnect().prepareCall("{call insertDepartment(?)}");
            cs.setNString(1, department.getDepartmentName());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(String DepartmentName) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistDepartmentName2(?)}");
            cs.setNString(1, DepartmentName);
            ResultSet rs = cs.executeQuery();
            rs.next();
            if (rs.getInt(1) > 0) {
                Message.error("Can't delete data!\n" + DepartmentName + " already exist in the Employee's database.");
                return 0;
            }
            cs = getConnect().prepareCall("{call deleteDepartment(?)}");
            cs.setNString(1, DepartmentName);
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
        
    }
}
