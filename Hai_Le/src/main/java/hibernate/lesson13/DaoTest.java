package hibernate.lesson13;

import hibernate.lesson13.dao.AuthorDAO;
import hibernate.lesson13.dao.BookDAO;
import hibernate.lesson13.dao.impl.AuthorDAOImpl;
import hibernate.lesson13.dao.impl.BookDAOImpl;
import hibernate.lesson13.entity.Author;
import hibernate.lesson13.entity.Book;
import hibernate.lesson13.util.HibernateUtil;

import java.util.List;

public class DaoTest {

    public static void testAuthor() {

        Author author1 = new Author("Irvin", "Show");
        Author author2 = new Author("Alexandr", "Pushkin");

        AuthorDAO authorDAO = new AuthorDAOImpl();

        System.out.println("Test create");
        System.out.println(authorDAO.create(author1));
        authorDAO.create(author2);

        System.out.println("Test findAll");
        List<Author> authors = authorDAO.findAll();
        for(Author author : authors) {
            System.out.println(author);
        }

        System.out.println("Test read");
        System.out.println(authorDAO.read(1L));

        System.out.println("Test update");
        Author author3 = authorDAO.read(2L);
        author3.setName("Anna");
        author3.setSurname("Ahmatova");
        System.out.println(authorDAO.update(author3));

        System.out.println("Test delete");
        authorDAO.delete(author3);

        authors = authorDAO.findAll();
        for(Author author : authors) {
            System.out.println(author);
        }
    }


    public static void testBook() {
        Book book1 = new Book("Black City","Detective");
        Book book2 = new Book("Robinson Cruso", "Robinsonada");

        BookDAO bookDAO = new BookDAOImpl();

        System.out.println("Test create");
        System.out.println(bookDAO.create(book1));
        System.out.println(bookDAO.create(book2));

        System.out.println("Test findAll");
        List<Book> books = bookDAO.findAll();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        HibernateUtil.getFactory();

        Author author1 = new Author("A1", "A1");
        Author author2 = new Author("A2", "A2");

        Book book1 = new Book("B1", "B2");
        Book book2 = new Book("B2", "B2");

        AuthorDAO authorDAO = new AuthorDAOImpl();
        BookDAO bookDAO =  new BookDAOImpl();

        authorDAO.create(author1);
        authorDAO.create(author2);

        book1.setAuthor(author1);
        bookDAO.create(book1);

        book2.setAuthor(author2);
        bookDAO.create(book2);

        HibernateUtil.getFactory().close();
    }

}
