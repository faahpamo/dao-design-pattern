/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testapp;

import dao.*;
import model.*;

/**
 *
 * @author Faisal Ahmed Pasha Mohammed https://faimoh.github.io
 */
public class DAOTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        DAOFactory dao = DAOFactory.getDAOFactory(DAOFactory.MySQLDataSource);
        BooksDAO booksDAO = dao.getBooksDAO();
        Book book = booksDAO.findBook(1);
        System.out.println(book);        
        dao = DAOFactory.getDAOFactory(DAOFactory.DerbyDataSource);
        booksDAO = dao.getBooksDAO();
        book = booksDAO.findBook(1);
        System.out.println(book);       
        for (Book b : booksDAO.getAllBooks()) {
            System.out.println(b);
        }
        dao = DAOFactory.getDAOFactory(DAOFactory.MySQLDataSource);
        booksDAO = dao.getBooksDAO();
        for (Book b : booksDAO.getAllBooks()) {
            System.out.println(b);
        }
    }

}
