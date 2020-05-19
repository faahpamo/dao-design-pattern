/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.mysql;

import dao.*;
import dao.mysql.*;
import java.sql.*;
import javax.sql.*;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

/**
 *
 * @author Faisal Ahmed Pasha Mohammed https://faimoh.github.io
 */
public class MysqlDataSourceDAOFactory extends DAOFactory {

    private static MysqlDataSourceDAOFactory mysqlDataSourceDAOFactory;
    private static MysqlConnectionPoolDataSource dataSource;
    private static DatabaseMetaData dbMetaData;

    private MysqlDataSourceDAOFactory() {
        try {
            dataSource = new MysqlConnectionPoolDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/booklib");
            dataSource.setUser("root");
            dataSource.setPassword("root");
        } catch (Exception e) {
            e.printStackTrace();
            dataSource = null;
        }
    }

    public BooksDAO getBooksDAO() {
        return new MysqlDataSourceBooksDAOImpl();
    }

    public static MysqlDataSourceDAOFactory getInstance() {
        if (mysqlDataSourceDAOFactory == null) {
            mysqlDataSourceDAOFactory = new MysqlDataSourceDAOFactory();
        }
        return mysqlDataSourceDAOFactory;
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
