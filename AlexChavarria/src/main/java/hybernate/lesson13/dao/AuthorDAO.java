package hybernate.lesson13.dao;

import hybernate.lesson13.entity.Author;

import java.util.List;

public interface AuthorDAO {
Long create(Author author);
Author read(Long id);
boolean update(Author author);
boolean delete(Author author);

List<Author> findAll();

}
