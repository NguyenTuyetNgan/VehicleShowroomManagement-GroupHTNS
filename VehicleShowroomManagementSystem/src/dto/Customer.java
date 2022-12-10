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
public class Customer {
    private long CustomerID;
    private String FirstName, LastName, Address;
    private Date DateOfBirth;
    private int Phone;
    private boolean Sex;

    public Customer() {
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public Customer(long CustomerID, String FirstName, String LastName, String Address, Date DateOfBirth, int Phone, boolean Sex) {
        this.CustomerID = CustomerID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.DateOfBirth = DateOfBirth;
        this.Phone = Phone;
        this.Sex = Sex;
    }


    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getAddress() {
        return Address;
    }

    public Date getDateOfBirth() {
        return DateOfBirth;
    }

    public int getPhone() {
        return Phone;
    }

    public boolean isSex() {
        return Sex;
    }

    public void setCustomerID(long CustomerID) {
        this.CustomerID = CustomerID;
    }


    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }


    public void setDateOfBirth(Date DateOfBirth) {
        this.DateOfBirth = DateOfBirth;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public void setSex(boolean Sex) {
        this.Sex = Sex;
    }
}
