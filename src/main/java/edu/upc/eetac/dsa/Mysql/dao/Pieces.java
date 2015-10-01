package edu.upc.eetac.dsa.Mysql.dao;

/**
 * Created by marc on 1/10/15.
 */
public class Pieces {
    private int Code;
    private String Text;

    public Pieces(int code, String text) {
        Code = code;
        Text = text;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
