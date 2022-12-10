/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * 
 */
public class Employee {

    private long EmployeeID;
    private int Phone;
    private boolean Sex;
    private String FirstName, LastName, Address, DepartmentName, UserName, Password;
    private byte[] Photo;
    private Date DateOfBirth;

    public Employee() {
    }

    public Employee(long EmployeeID, int Phone, boolean Sex, String FirstName, String LastName, String Address, String DepartmentName, byte[] Photo, Date DateOfBirth, String UserName, String Password) {
        this.EmployeeID = EmployeeID;
        this.Phone = Phone;
        this.Sex = Sex;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.DepartmentName = DepartmentName;
        this.Photo = Photo;
        this.DateOfBirth = DateOfBirth;
        this.UserName = UserName;
        this.Password = Password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] Photo) {
        this.Photo = Photo;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

   
}
