/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 *
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import dto.Customer;
import dto.Employee;
import gui.Main;
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
public class EmployeeDAO extends Connect {

    public ArrayList getList() {
        try {
            ArrayList list = new ArrayList();
            Statement st = null;
            st = getConnect().createStatement();
            ResultSet rs = st.executeQuery("Select * from Employee");
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(rs.getLong("EmployeeID"));
                emp.setDepartmentName(rs.getNString("DepartmentName"));
                emp.setFirstName(rs.getNString("FirstName"));
                emp.setSex(rs.getBoolean("Sex"));
                emp.setLastName(rs.getNString("LastName"));
                emp.setDateOfBirth(rs.getDate("DateOfBirth"));
                emp.setAddress(rs.getNString("Address"));
                emp.setPhone(rs.getInt("Phone"));
                emp.setPhoto(rs.getBytes("Photo"));
                emp.setUserName(rs.getString("UserName"));
                emp.setPassword(rs.getString("Password"));
                list.add(emp);
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
            cs = getConnect().prepareCall("{call searchEmployee(?)}");
            cs.setNString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmployeeID(rs.getLong("EmployeeID"));
                emp.setDepartmentName(rs.getNString("DepartmentName"));
                emp.setFirstName(rs.getNString("FirstName"));
                emp.setSex(rs.getBoolean("Sex"));
                emp.setLastName(rs.getNString("LastName"));
                emp.setDateOfBirth(rs.getDate("DateOfBirth"));
                emp.setAddress(rs.getNString("Address"));
                emp.setPhone(rs.getInt("Phone"));
                emp.setPhoto(rs.getBytes("Photo"));
                emp.setUserName(rs.getString("UserName"));
                emp.setPassword(rs.getString("Password"));
                list.add(emp);
            }
            CloseConnection();
            return list;
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNew(Employee emp) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call insertEmployee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setNString(1, emp.getDepartmentName());
            cs.setNString(2, emp.getFirstName());
            cs.setNString(3, emp.getLastName());
            cs.setBytes(4, emp.getPhoto());
            cs.setBoolean(5, emp.isSex());
            cs.setDate(6, emp.getDateOfBirth());
            cs.setNString(7, emp.getAddress());
            cs.setInt(8, emp.getPhone());
            cs.setString(9, emp.getUserName());
            cs.setString(10, emp.getPassword());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int update(Employee emp) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call updateEmployee(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            cs.setNString(1, emp.getDepartmentName());
            cs.setNString(2, emp.getFirstName());
            cs.setNString(3, emp.getLastName());
            cs.setBytes(4, emp.getPhoto());
            cs.setBoolean(5, emp.isSex());
            cs.setDate(6, emp.getDateOfBirth());
            cs.setNString(7, emp.getAddress());
            cs.setInt(8, emp.getPhone());
            cs.setString(9, emp.getUserName());
            cs.setString(10, emp.getPassword());
            cs.setLong(11, emp.getEmployeeID());
            int row = cs.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int delete(long ID) {
        if (Main.EmployeeID == ID) {
            Message.error("Can't delete this user currently using system!");
            return 0;
        }
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call isExistEmployee(?)}");
            cs.setLong(1, ID);
            ResultSet rs = cs.executeQuery();
            rs.next();
            
            PreparedStatement pst;
            pst = getConnect().prepareStatement("delete from Employee where EmployeeID = (?)");
            pst.setLong(1, ID);
            int row =  pst.executeUpdate();
            CloseConnection();
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public Employee getEmployee(long ID) {
        PreparedStatement pst;
        try {
            pst = getConnect().prepareStatement("select * from Employee where EmployeeID = (?)");
            pst.setLong(1, ID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Employee emp = new Employee(rs.getLong("EmployeeID"), rs.getInt("Phone"), rs.getBoolean("Sex"), rs.getNString("FirstName"), rs.getNString("LastName"), rs.getNString("Address"), rs.getNString("DepartmentName"), rs.getBytes("Photo"), rs.getDate("DateOfBirth"), rs.getString("UserName"), rs.getString("Password"));
            CloseConnection();
            return emp;
        } catch (Exception ex) {
            return null;
        }
    }

    public Employee getEmployee(String UserName, String Password, String DepartmentName) {
        CallableStatement cs;
        try {
            cs = getConnect().prepareCall("{call getEmployee(?, ?, ?)}");
            cs.setString(1, UserName);
            cs.setString(2, Password);
            cs.setString(3, DepartmentName);
            ResultSet rs = cs.executeQuery();
            rs.next();
            Employee emp = new Employee(rs.getLong("EmployeeID"), rs.getInt("Phone"), rs.getBoolean("Sex"), rs.getNString("FirstName"), rs.getNString("LastName"), rs.getNString("Address"), rs.getNString("DepartmentName"), rs.getBytes("Photo"), rs.getDate("DateOfBirth"), rs.getString("UserName"), rs.getString("Password"));
            CloseConnection();
            return emp;
        } catch (Exception ex) {
            return null;
        }
    }
}
