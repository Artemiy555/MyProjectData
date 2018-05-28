package hibernate.lesson13.dao;

import hibernate.lesson13.entity.Autor;
import hibernate.lesson13.entity.Book;

import java.util.List;

public interface BookDao {

    Long create(Book book);
    Autor read (Long id);
    boolean updete(Book book);
    boolean delete(Book book);
    List<Book> finAll();


}
