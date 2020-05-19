/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.derby;

import dao.*;
import dao.mysql.*;
import java.sql.*;
import javax.sql.*;
import org.apache.derby.client.*;
import org.apache.derby.jdbc.ClientConnectionPoolDataSource;


/**
 *
 * @author Faisal Ahmed Pasha Mohammed https://faimoh.github.io
 */
public class DerbyDataSourceDAOFactory extends DAOFactory {

    private static DerbyDataSourceDAOFactory derbyDataSourceDAOFactory;
    private static ClientConnectionPoolDataSource dataSource;
    private static DatabaseMetaData dbMetaData;

    private DerbyDataSourceDAOFactory() {
        try {
            //dataSource = new org.apache.derby.client.BasicClientDataSource();  
            dataSource = new org.apache.derby.jdbc.ClientConnectionPoolDataSource();
            dataSource.setServerName("localhost");
            dataSource.setPortNumber(1527);
            dataSource.setDatabaseName("booklib");
        } catch (Exception e) {
            e.printStackTrace();
            dataSource = null;
        }
    }

    public static DerbyDataSourceDAOFactory getInstance() {
        if (derbyDataSourceDAOFactory == null) {
            derbyDataSourceDAOFactory = new DerbyDataSourceDAOFactory();
        }
        return derbyDataSourceDAOFactory;
    }

    public BooksDAO getBooksDAO() {
        return new DerbyDataSourceBooksDAOImpl();
    }

    public Connection getConnection() {
        try {
            Connection c = dataSource.getConnection();
            dbMetaData = c.getMetaData();
            int majorVersion = dbMetaData.getDatabaseMajorVersion();
            int minorVersion = dbMetaData.getDatabaseMinorVersion();
            String productName = dbMetaData.getDatabaseProductName();
            String productVersion = dbMetaData.getDatabaseProductVersion();
            System.out.println("You are connected to database: "
                    + productName + ", "
                    + productVersion + ", "
                    + majorVersion + ", "
                    + minorVersion);
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void freeConnection(Connection c) {
        try {            
            c.close();
            System.out.println("Your database connection to " + dbMetaData.getDatabaseProductName() + " is now closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
