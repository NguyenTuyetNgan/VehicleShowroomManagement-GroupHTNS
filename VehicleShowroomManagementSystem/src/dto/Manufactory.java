/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * 
 */
public class Manufactory {

    private int ManufactoryID, Phone;
    private String AddInfor, Name, Address;
    private byte[] Logo;

    public Manufactory() {
    }

    public Manufactory(int ManufactoryID, int Phone, String AddInfor, String Name, String Address, byte[] Logo) {
        this.ManufactoryID = ManufactoryID;
        this.Phone = Phone;
        this.AddInfor = AddInfor;
        this.Name = Name;
        this.Address = Address;
        this.Logo = Logo;
    }

    public int getManufactoryID() {
        return ManufactoryID;
    }

    public void setManufactoryID(int ManufactoryID) {
        this.ManufactoryID = ManufactoryID;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int Phone) {
        this.Phone = Phone;
    }

    public String getAddInfor() {
        return AddInfor;
    }

    public void setAddInfor(String AddInfor) {
        this.AddInfor = AddInfor;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public byte[] getLogo() {
        return Logo;
    }

    public void setLogo(byte[] Logo) {
        this.Logo = Logo;
    }
}
