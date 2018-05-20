package hibernate.lesson13;

import hibernate.lesson13.dao.AuthorDAO;
import hibernate.lesson13.dao.impl.AuthorDAOImpl;
import hibernate.lesson13.entity.Author;
import hibernate.lesson13.util.HibernateUtil;

import java.util.List;

public class DaoTest {

    public static void main(String[] args) {
        Author author1 = new Author("Irvin", "Show");
        Author author2 = new Author("Alexandr", "Pushkin");

        AuthorDAO authorDAO = new AuthorDAOImpl();

        System.out.println("Test create()");
        System.out.println(authorDAO.create(author1));
        System.out.println(authorDAO.create(author2));

        System.out.println("Test findAll()");
        List<Author> authors = authorDAO.findAll();
        for (Author author : authors) {
            System.out.println(author);
        }
        System.out.println("Test read()");
        System.out.println(authorDAO.read(1L));

        System.out.println("Test update()");
        Author author3 = authorDAO.read(2L);
        author3.setName("Anna");
        author3.setSurname("Ahmatova");
        System.out.println(authorDAO.update(author3));

        System.out.println("Test delete()");
        authorDAO.delete(author3);
        authors = authorDAO.findAll();
        for (Author author : authors) {
            System.out.println(author);
        }

        HibernateUtil.getFactory().close();
    }

}
