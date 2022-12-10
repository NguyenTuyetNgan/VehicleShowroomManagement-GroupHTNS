/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * 
 */
public class ServiceDetails {

    private int ServiceID;
    private long CarNo;

    public ServiceDetails() {
    }

    public ServiceDetails(int ServiceID, long CarNo) {
        this.ServiceID = ServiceID;
        this.CarNo = CarNo;
    }

    public int getServiceID() {
        return ServiceID;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public long getCarNo() {
        return CarNo;
    }

    public void setCarNo(long CarNo) {
        this.CarNo = CarNo;
    }
}
