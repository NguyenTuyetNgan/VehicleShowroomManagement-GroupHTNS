/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 *
 */
public class Car {

    private long CarNo;
    private float Price;
    private String Name, AddInfor, ModelName;
    private boolean Status;

    public Car() {
    }

    public Car(long CarNo, String ModelName, float Price, String Name, String AddInfor, boolean Status) {
        this.CarNo = CarNo;
        this.ModelName = ModelName;
        this.Price = Price;
        this.Name = Name;
        this.AddInfor = AddInfor;
        this.Status = Status;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public long getCarNo() {
        return CarNo;
    }

    public void setCarNo(long CarNo) {
        this.CarNo = CarNo;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddInfor() {
        return AddInfor;
    }

    public void setAddInfor(String AddInfor) {
        this.AddInfor = AddInfor;
    }
}
