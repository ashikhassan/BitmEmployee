package com.emythmakers.ashik.bitmemployee.database;

/**
 * Created by BITM Trainer 401 on 18/8/2015.
 */
public class ContactModel {

    private  String id;
    private String name;
    private  String phoneNo;
    private String designation;
    private static String positionID;

    public static String getPositionID() {
        return positionID;
    }

    public static void setPositionID(String positionID) {
        ContactModel.positionID = positionID;
    }

    public ContactModel(String id, String name, String phoneNo, String designation) {
        this.id = id;
        setName(name);
        setPhoneNo(phoneNo);
        setDesignation(designation);
    }

    public ContactModel(String name, String phoneNo, String designation) {
        setName(name);
        setPhoneNo(phoneNo);
        setDesignation(designation);
    }
    public ContactModel(String name) {
        setName(name);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
