package com.example.myform;

import java.security.PublicKey;

public class modelclass {
    private String name;
    private String fname;
    private String mname;
    private String gender;
    private String dob;
    private String local_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocal_id() {
        return local_id;
    }

    public void setLocal_id(String local_id) {
        this.local_id = local_id;
    }

    private static final String TABLE_NAME="Student_Record";
    public static final String COLUMN_LOCAL_ID="local_id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_D_O_B="dob";
    public static final String COLUMN_FATHERNAME="fname";
    public static final String COLUMN_MOTHERNMAE="mname";
    public static final String COLUMN_GENDER="gender";

   public static final String CREATE_TABLE=
           " CREATE TABLE "+ TABLE_NAME + "("
           + COLUMN_LOCAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
           + COLUMN_NAME + " TEXT , "
           + COLUMN_D_O_B + " TEXT , "
           + COLUMN_FATHERNAME + " TEXT , "
           + COLUMN_MOTHERNMAE + " TEXT , "
           + COLUMN_GENDER + " TEXT " +
           ")" ;
}
