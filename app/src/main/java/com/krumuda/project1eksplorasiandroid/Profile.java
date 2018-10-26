package com.krumuda.project1eksplorasiandroid;

public class Profile {
    static String name, nim, facultymajor, contact;

    Profile() {
        this.name = "";
        this.nim= "";
        this.facultymajor = "";
        this.contact = "";
    }

    Profile(String name, String nim, String facultymajor, String contact) {
        this.name = name;
        this.nim= nim;
        this.facultymajor = facultymajor;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getNim() {
        return nim;
    }

    public String getFacultyMajor() {
        return facultymajor;
    }

    public String getContact() {
        return contact;
    }
}
