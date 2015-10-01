package edu.upc.eetac.dsa.Mysql.mysql;

/**
 * Created by marc on 1/10/15.
 */

public class Main {
  public static void main(String[] args) throws Exception {
    MySQLAccess dao = new MySQLAccess();
    dao.readDataBase();
  }

} 