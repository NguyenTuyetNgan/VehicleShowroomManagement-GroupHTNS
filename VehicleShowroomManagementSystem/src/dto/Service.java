/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 *
 */
public class Service {

    private int ServiceID;
    private String Name, Description;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Service() {
    }
    

    public Service(int ServiceID, String Name, String Desscription) {
        this.ServiceID = ServiceID;
        this.Name = Name;
        this.Description = Desscription;
    }

    public int getServiceID() {
        return ServiceID;
    }

    public void setServiceID(int ServiceID) {
        this.ServiceID = ServiceID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
