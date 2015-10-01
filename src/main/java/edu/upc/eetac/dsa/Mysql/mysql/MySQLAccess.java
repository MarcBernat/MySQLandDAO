package edu.upc.eetac.dsa.Mysql.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by marc on 1/10/15.
 */


public class MySQLAccess {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;

  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
      Class.forName("com.mysql.jdbc.Driver");
      // Setup the connection with the DB
      connect = DriverManager
          .getConnection("jdbc:mysql://localhost/PiecesandProviders?"
              + "user=root");

      /**
       * Querys
       */

      // Crea una secuencia
      statement = connect.createStatement();
      // Guardamos el resultado de la query en
      resultSet = statement
          .executeQuery("SELECT * FROM Pieces");
      writeMetaData(resultSet);

      preparedStatement = connect
          .prepareStatement("SELECT * FROM Providers");
      resultSet = preparedStatement.executeQuery();
      writeMetaData(resultSet);

      preparedStatement = connect
              .prepareStatement("SELECT Piece, AVG(Price) FROM Provides");
      resultSet = preparedStatement.executeQuery();
      writeMetaData(resultSet);

      preparedStatement = connect
              .prepareStatement("SELECT Provider FROM Provides INNER JOIN Pieces ON Provides.Piece = Pieces.Code AND Piece = 1");
      resultSet = preparedStatement.executeQuery();
      writeMetaData(resultSet);

      preparedStatement = connect
              .prepareStatement("SELECT Name FROM Pieces WHERE Code IN (SELECT Piece FROM Provides WHERE Provider = 'HAL')");
      resultSet = preparedStatement.executeQuery();
      writeMetaData(resultSet);


      preparedStatement = connect
              .prepareStatement("SELECT Pieces.Name, Providers.Name, Price FROM Pieces INNER JOIN Provides ON Pieces.Code = Piece INNER JOIN Providers ON Providers.Code = Provider WHERE Price = (SELECT MAX(Price) FROM Provides WHERE Piece = Pieces.Code)");
      resultSet = preparedStatement.executeQuery();
      writeMetaData(resultSet);

      preparedStatement = connect
              .prepareStatement("INSERT INTO Provides VALUES (1, 'TNBC', 7)");
      preparedStatement.executeUpdate();
      //
      preparedStatement = connect
              .prepareStatement("UPDATE Provides SET Price = Price + 1");
      preparedStatement.executeUpdate();

      preparedStatement = connect
              .prepareStatement("DELETE FROM Provides WHERE Provider = 'RBT' AND Piece = 4");
      preparedStatement.executeUpdate();

      preparedStatement = connect
              .prepareStatement("DELETE FROM Provides WHERE Provider = 'RBT'");
      preparedStatement.executeUpdate();
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }


  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 