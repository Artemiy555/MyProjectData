package hibernate.lesson13.dao;

import hibernate.lesson13.entity.Book;

import java.util.List;

public interface BookDAO {

    Long create(Book book);

    Book read(long id);

    boolean update(Book book);

    boolean delete(Book book);

    List<Book> findAll();


}
