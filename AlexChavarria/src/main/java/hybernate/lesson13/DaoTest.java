package hybernate.lesson13;

import hybernate.lesson13.dao.AuthorDAO;
import hybernate.lesson13.dao.BookDAO;
import hybernate.lesson13.dao.impl.AuthorDAOImpl;
import hybernate.lesson13.dao.impl.BookDAOimpl;
import hybernate.lesson13.entity.Author;
import hybernate.lesson13.entity.Book;
import hybernate.lesson13.util.HibernateUtil;

import java.util.List;

public class DaoTest {

    public static void main(String[] args) {
      //  HibernateUtil.getFactory();

        Author author1 = new Author("Irvin","Show");
        Author author2 = new Author("Alexandr","Pushkin");
        Author author3 = new Author("Vadim","Sevruk");
        Book book1 = new Book("1stBook","WOW");
        Book book2 = new Book("2ndBook","LOL");
        Book book3 = new Book("3thBook","OMG");


        System.out.println("Test create author");
        AuthorDAO authorDAO = new AuthorDAOImpl();
        authorDAO.create(author1);
        authorDAO.create(author2);
        authorDAO.create(author3);

        System.out.println("Test create book");
        BookDAO bookDAO= new BookDAOimpl();
        book1.setAuthor(author1);
        bookDAO.create(book1);
        book2.setAuthor(author2);
        bookDAO.create(book2);
        book3.setAuthor(author3);
        bookDAO.create(book3);

        System.out.println("Test findAll author");
        List<Author> authors = authorDAO.findAll();
        for (Author author : authors){
            System.out.println(author);
        }

        System.out.println("Test findAll book");
        List<Book> books = bookDAO.findAll();
        for (Book book : books){
            System.out.println(book);
        }


        System.out.println("Test read author");
        System.out.println(authorDAO.read(1L));

        System.out.println("Test read book");
        System.out.println(bookDAO.read(1L));

        System.out.println("Test update author");
        Author author4 = authorDAO.read(2L);
        author4.setName("Anna");
        author4.setSurname("Ahmatova");
        System.out.println(authorDAO.update(author4));

        System.out.println("Test update book");
        Book book4 = bookDAO.read(2L);
        book4.setTitle("4thBook");
        book4.setDescription("WTF");
        System.out.println(bookDAO.update(book4));

        System.out.println("Test delete author");
        authorDAO.delete(author3);
        authors = authorDAO.findAll();
        for (Author author : authors){

            System.out.println(author);
        }

        System.out.println("Test delete book");
        bookDAO.delete(book3);
        books = bookDAO.findAll();
        for (Book book : books){

            System.out.println(book);
        }

        HibernateUtil.getFactory().close();

    }
}
