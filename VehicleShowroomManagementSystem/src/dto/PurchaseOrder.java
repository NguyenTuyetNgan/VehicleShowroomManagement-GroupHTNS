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
public class PurchaseOrder {

    private long PurchaseOrderID, EmployeeID;
    private Date Date;

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public PurchaseOrder() {
    }

    public PurchaseOrder(long PurchaseOrderID, Date date, long EmployeeID) {
        this.PurchaseOrderID = PurchaseOrderID;
        this.Date = date;
        this.EmployeeID = EmployeeID;
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public long getPurchaseOrderID() {
        return PurchaseOrderID;
    }

    public void setPurchaseOrderID(long PurchaseOrderID) {
        this.PurchaseOrderID = PurchaseOrderID;
    }
}
