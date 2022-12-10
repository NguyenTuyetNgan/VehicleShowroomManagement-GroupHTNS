/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bll;

import dto.*;
import dao.*;
import gui.Message;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * 
 */
public class Manager {

    public ArrayList getList(String type) {
        ArrayList list = new ArrayList();
        switch (type) {
            case "employee":
                list = new EmployeeDAO().getList();
                break;
            case "department":
                list = new DepartmentDAO().getList();
                break;
            case "car":
                list = new CarDAO().getList();
                break;
            case "model":
                list = new CarModelDAO().getList();
                break;
            case "receipt":
                list = new CarReceiptDAO().getList();
                break;
            case "manufactory":
                list = new ManufactoryDAO().getList();
                break;
            case "order":
                list = new OrderDAO().getList();
                break;
            case "orderDetails":
                list = new OrderDetailsDAO().getList();
                break;
            case "service":
                list = new ServiceDAO().getList();
                break;
            case "assigning":
                list = new AssigningDAO().getList();
                break;
            case "purchase":
                list = new PurchaseOrderDAO().getList();
                break;
            case "serviceDetails":
                list = new ServiceDetailsDAO().getList();
                break;
            case "purchaseDetails":
                list = new PurchaseOrderDetailsDAO().getList();
                break;
            case "customer":
                list = new CustomerDAO().getList();
                break;
        }
        return list;
    }

    public void addNew(Object obj, String type) {
        switch (type) {
            case "orderDetails":
                new OrderDetailsDAO().addNew((OrderDetails) obj);
                return;
            case "serviceDetails":
                new ServiceDetailsDAO().addNew((ServiceDetails) obj);
                return;
            case "purchaseDetails":
                new PurchaseOrderDetailsDAO().addNew((PurchaseOrderDetails) obj);
                return;
        }
        if (Message.confirm("Are you sure to add new this " + type.toUpperCase() + "?")) {
            switch (type) {
                case "employee":
                    new EmployeeDAO().addNew((Employee) obj);
                    break;
                case "department":
                    if (new DepartmentDAO().addNew((Department) obj)==0) {
                        return;
                    }
                    break;
                case "car":
                    new CarDAO().addNew((Car) obj);
                    break;
                case "model":
                    new CarModelDAO().addNew((CarModel) obj);
                    break;
                case "receipt":
                    new CarReceiptDAO().addNew((CarReceipt) obj);
                    break;
                case "manufactory":
                    new ManufactoryDAO().addNew((Manufactory) obj);
                    break;
                case "order":
                    new OrderDAO().addNew((Order) obj);
                    break;
                case "service":
                    new ServiceDAO().addNew((Service) obj);
                    break;
                case "assigning":
                    new AssigningDAO().addNew((Assigning) obj);
                    break;
                case "purchase":
                    new PurchaseOrderDAO().addNew((PurchaseOrder) obj);
                    break;
                case "customer":
                    new CustomerDAO().addNew((Customer) obj);
                    break;
            }
            Message.infor("Add information successful!");
            return;
        }
    }

    public void update(Object obj, String type) {
        switch (type) {
            case "orderDetails":
                new OrderDetailsDAO().update((OrderDetails) obj);
                return;
            case "purchaseDetails":
                new PurchaseOrderDetailsDAO().update((PurchaseOrderDetails) obj);
                return;

        }
        if (Message.confirm("Are you sure to update for " + type.toUpperCase() + "?")) {
            switch (type) {
                case "customer":
                    new CustomerDAO().update((Customer) obj);
                    break;
                case "employee":
                    new EmployeeDAO().update((Employee) obj);
                    break;
                case "car":
                    new CarDAO().update((Car) obj);
                    break;
                case "model":
                    new CarModelDAO().update((CarModel) obj);
                    break;
                case "receipt":
                    new CarReceiptDAO().update((CarReceipt) obj);
                    break;
                case "manufactory":
                    new ManufactoryDAO().update((Manufactory) obj);
                    break;
                case "order":
                    new OrderDAO().update((Order) obj);
                    break;
                case "service":
                    new ServiceDAO().update((Service) obj);
                    break;
                case "assigning":
                    new AssigningDAO().update((Assigning) obj);
                    break;
                case "purchase":
                    new PurchaseOrderDAO().update((PurchaseOrder) obj);
                    break;

            }
            Message.infor("Successfully updated information!");
            return;
        }
    }

    public void delete(long ID, String type) {
        switch (type) {
            case "serviceDetails":
                new ServiceDetailsDAO().delete(ID);
                return;
        }
        if (Message.confirm("Are you sure to delete this " + type.toUpperCase() + "?")) {
            switch (type) {
                case "customer":
                    if (new CustomerDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "employee":
                    if (new EmployeeDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "car":
                    if (new CarDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "receipt":
                    if (new CarReceiptDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "manufactory":
                    if (new ManufactoryDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "order":
                    if (new OrderDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "service":
                    if (new ServiceDAO().delete((int) ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "assigning":
                    if (new AssigningDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "purchase":
                    if (new PurchaseOrderDAO().delete(ID) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
            }
            return;
        }
    }

    public void delete(String Name, String type) {
        if (Message.confirm("Are you sure to delete this " + type.toUpperCase() + "?")) {
            switch (type) {
                case "department":
                    if (new DepartmentDAO().delete(Name) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
                case "model":
                    if (new CarModelDAO().delete(Name) > 0) {
                        Message.infor("Successfully deleted information!");
                    }
                    break;
            }
        }
    }

    public ResultSet getOrderDetails(long OrderID) {
        CallableStatement cs;
        try {
            cs = Connect.getConnect().prepareCall("{call getOrderDetails(?)}");
            cs.setLong(1, OrderID);
            return cs.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getPurchaseOrderDetails(long OrderID) {
        CallableStatement cs;
        try {
            cs = Connect.getConnect().prepareCall("{call getPurchaseOrderDetails(?)}");
            cs.setLong(1, OrderID);
            return cs.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public BigDecimal getNewID(String tableName) {
        CallableStatement cs;
        try {
            cs = Connect.getConnect().prepareCall("{call getNewIdentity(?)}");
            cs.setString(1, tableName);
            ResultSet rs = cs.executeQuery();
            rs.next();
            BigDecimal ID = (BigDecimal) rs.getObject("ID");
            return ID;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
