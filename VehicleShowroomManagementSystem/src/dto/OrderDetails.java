/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 *
 */
public class OrderDetails {

    private long OrderID, CarNo;
    private int Quantity;

    public OrderDetails() {
    }

    public OrderDetails(long OrderID, long CarNo, int Quantity) {
        this.OrderID = OrderID;
        this.CarNo = CarNo;
        this.Quantity = Quantity;
    }

    public long getOrderID() {
        return OrderID;
    }

    public void setOrderID(long OrderID) {
        this.OrderID = OrderID;
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
}
