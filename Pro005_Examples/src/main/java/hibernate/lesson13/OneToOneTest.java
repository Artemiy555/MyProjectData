package hibernate.lesson13;

import hibernate.lesson13.dao.AuthorDAO;
import hibernate.lesson13.dao.BookDAO;
import hibernate.lesson13.dao.impl.AuthorDAOImpl;
import hibernate.lesson13.dao.impl.BookDAOImpl;
import hibernate.lesson13.entity.Author;
import hibernate.lesson13.entity.Book;
import hibernate.lesson13.util.HibernateUtil;

public class OneToOneTest {

    public static void main(String[] args) {
        Author author1 = new Author("Author1 Name", "Author1 Surname");
        Author author2 = new Author("Author2 Name", "Author2 Surname");

        Book book1 = new Book("Book1", "Book1 Description");
        Book book2 = new Book("Book2", "Book2 Description");
        Book book3 = new Book("Book3", "Book3 Description");

        AuthorDAO authorDAO = new AuthorDAOImpl();
        BookDAO bookDAO = new BookDAOImpl();

        authorDAO.create(author1);
        authorDAO.create(author2);

        book1.setAuthor(author1);
        bookDAO.create(book1);

        book2.setAuthor(author2);
        bookDAO.create(book2);

        bookDAO.create(book3);

        HibernateUtil.getFactory().close();
    }
}
