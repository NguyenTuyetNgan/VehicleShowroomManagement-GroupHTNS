/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 *
 */
public class CarModel {

    private byte[] Image;
    private String ModelName, AddInfor;
    private int ManufactoryID;

    public int getManufactoryID() {
        return ManufactoryID;
    }

    public void setManufactoryID(int ManufactoryID) {
        this.ManufactoryID = ManufactoryID;
    }

    public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String ModelName) {
        this.ModelName = ModelName;
    }

    public String getAddInfor() {
        return AddInfor;
    }

    public void setAddInfor(String AddInfor) {
        this.AddInfor = AddInfor;
    }

    public CarModel(byte[] Image, String ModelName, String AddInfor, int ManufactoryID) {
        this.Image = Image;
        this.ModelName = ModelName;
        this.AddInfor = AddInfor;
        this.ManufactoryID = ManufactoryID;
    }

    public CarModel() {
    }
}
