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
public class Order {

    private long OrderID, CustomerID, EmployeeID;
    private Date OnOrder;
    private boolean Confirmation;
    private String Request;

    public Order() {
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public Order(long OrderID, long CustomerID, Date OnOrder, boolean Confirmation, String Request, long EmployeeID) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OnOrder = OnOrder;
        this.Confirmation = Confirmation;
        this.Request = Request;
        this.EmployeeID = EmployeeID;
    }

    public long getOrderID() {
        return OrderID;
    }

    public void setOrderID(long OrderID) {
        this.OrderID = OrderID;
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(long CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Date getOnOrder() {
        return OnOrder;
    }

    public void setOnOrder(Date OnOrder) {
        this.OnOrder = OnOrder;
    }

    public boolean isConfirmation() {
        return Confirmation;
    }

    public void setConfirmation(boolean Confirmation) {
        this.Confirmation = Confirmation;
    }

    public String getRequest() {
        return Request;
    }

    public void setRequest(String Request) {
        this.Request = Request;
    }

   
}
