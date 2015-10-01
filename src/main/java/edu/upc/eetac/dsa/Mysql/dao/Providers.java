package edu.upc.eetac.dsa.Mysql.dao;

/**
 * Created by marc on 1/10/15.
 */
public class Providers {
    private String Code;
    private String Name;

    public Providers(String code, String name) {
        Code = code;
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
