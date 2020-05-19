/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.*;
import java.util.*;

/**
 *
 * @author Faisal Ahmed Pasha Mohammed https://faimoh.github.io
 */
public interface BooksDAO {
    public int insertBook(Book b);
    public boolean updateBook(Book b);
    public boolean deleteBook(Book b);
    public Book findBook(int id);
    public ArrayList<Book> getAllBooks();
}
