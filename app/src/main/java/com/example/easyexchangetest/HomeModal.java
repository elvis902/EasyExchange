package com.example.easyexchangetest;

/* Modal class */

public class HomeModal {
    String email, pDescription, pName, pUrl;

    HomeModal(){

    }

    public HomeModal(String email, String pDescription, String pName, String pUrl) {
        this.email = email;
        this.pDescription = pDescription;
        this.pName = pName;
        this.pUrl = pUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpDescription() {
        return pDescription;
    }

    public void setpDescription(String pDescription) {
        this.pDescription = pDescription;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpUrl() {
        return pUrl;
    }

    public void setpUrl(String pUrl) {
        this.pUrl = pUrl;
    }
}
