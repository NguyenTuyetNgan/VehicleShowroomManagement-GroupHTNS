/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * 
 */
public class PurchaseOrderDetails {
    long PurchaseOrderID, CarNo;
    int Quantity;
    float Price;

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public long getPurchaseOrderID() {
        return PurchaseOrderID;
    }

    public void setPurchaseOrderID(long PurchaseOrderID) {
        this.PurchaseOrderID = PurchaseOrderID;
    }

    public long getCarNo() {
        return CarNo;
    }

    public void setCarNo(long CarNo) {
        this.CarNo = CarNo;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public PurchaseOrderDetails(long PurchaseOrderID, long CarNo, int Quantity, float Price) {
        this.PurchaseOrderID = PurchaseOrderID;
        this.CarNo = CarNo;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    public PurchaseOrderDetails() {
    }
    
}
