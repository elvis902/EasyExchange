package com.example.easyexchangetest;

/*  This class is used to hold all the info of an add which is to be uploaded to Storage and the details uploaded to
* database .*/

public class AddDataHolder {
    String pName, pDescription, email, pUrl;

    public AddDataHolder(String pName, String pDescription, String email, String pUrl) {
        this.pName = pName;
        this.pDescription = pDescription;
        this.email = email;
        this.pUrl = pUrl;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }
}

