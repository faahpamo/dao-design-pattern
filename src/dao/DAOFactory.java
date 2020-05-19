/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.mysql.MysqlDataSourceDAOFactory;
import dao.derby.DerbyDataSourceDAOFactory;

/**
 *
 * @author Faisal Ahmed Pasha Mohammed https://faimoh.github.io
 */
public abstract class DAOFactory {

    public static final int MySQLDataSource = 1;
    public static final int DerbyDataSource = 2;

    public abstract BooksDAO getBooksDAO();

    public static DAOFactory getDAOFactory(int whichFactory) {
        switch (whichFactory) {
            case MySQLDataSource:
                return MysqlDataSourceDAOFactory.getInstance();
            case DerbyDataSource:
                return DerbyDataSourceDAOFactory.getInstance();
            default:
                return null;
        }
    }
}
