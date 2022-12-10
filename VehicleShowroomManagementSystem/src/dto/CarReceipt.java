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
public class CarReceipt {

    private long ReceiptID, PurchaseOrderID, EmployeeID;
    private Date Date;

    public CarReceipt() {
    }

    public CarReceipt(long ReceiptID, long PurchaseOrderID, long EmployeeID, Date Date) {
        this.ReceiptID = ReceiptID;
        this.PurchaseOrderID = PurchaseOrderID;
        this.Date = Date;
        this.EmployeeID = EmployeeID;
    }

    public long getPurchaseOrderID() {
        return PurchaseOrderID;
    }

    public void setPurchaseOrderID(long PurchaseOrderID) {
        this.PurchaseOrderID = PurchaseOrderID;
    }

    public long getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(long EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public long getReceiptID() {
        return ReceiptID;
    }

    public void setReceiptID(long ReceiptID) {
        this.ReceiptID = ReceiptID;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }
}
