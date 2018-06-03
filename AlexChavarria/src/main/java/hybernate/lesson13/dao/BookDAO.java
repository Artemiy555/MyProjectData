package hybernate.lesson13.dao;

import hybernate.lesson13.entity.Book;

import java.util.List;

public interface BookDAO {
    Long create(Book book);
    Book read (Long id);
    boolean update(Book book);
    boolean delete(Book book);

    List<Book> findAll();
}
