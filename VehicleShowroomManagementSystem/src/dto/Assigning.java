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
public class Assigning {

    private long OrderID, AssigningID, EmployeeID;
    private Date OnAssigning;

    public Assigning() {
    }

    public Assigning(long OrderID, long AssigningID, Date OnAssigning, long EmployeeID) {
        this.OrderID = OrderID;
        this.AssigningID = AssigningID;
        this.OnAssigning = OnAssigning;
        this.EmployeeID = EmployeeID;
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public long getOrderID() {
        return OrderID;
    }

    public void setOrderID(long OrderID) {
        this.OrderID = OrderID;
    }

    public long getAssigningID() {
        return AssigningID;
    }

    public void setAssigningID(long AssigningID) {
        this.AssigningID = AssigningID;
    }

    public Date getOnAssigning() {
        return OnAssigning;
    }

    public void setOnAssigning(Date OnAssigning) {
        this.OnAssigning = OnAssigning;
    }
}
