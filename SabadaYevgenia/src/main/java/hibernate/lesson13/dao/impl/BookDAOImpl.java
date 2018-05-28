package hibernate.lesson13.dao.impl;

import hibernate.lesson13.dao.BookDao;
import hibernate.lesson13.entity.Autor;
import hibernate.lesson13.entity.Book;
import hibernate.lesson13.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDAOImpl implements BookDao {

    private SessionFactory factory;
    public BookDAOImpl(){factory= HibernateUtil.getFactory();}
    @Override
    public Long create(Book book) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            Long id=(Long)session.save(book);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException exe){
            session.getTransaction().rollback();
            System.out.println("Error:"+ exe.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Autor read(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Autor.class, id);
        } catch (HibernateException exc) {
            System.out.println("Error![ID:" + id + "].");
            return null;
        }
    }

    @Override
    public boolean updete(Book book) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;

        }catch (HibernateException exc){
            session.getTransaction().rollback();
            System.out.println("Error!Update fail...");
            return false;
        }
    }

    @Override
    public boolean delete(Book book) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            return true;

        }catch (HibernateException exc){
            session.getTransaction().rollback();
            System.out.println("Error!Delet fail...");
            return false;
        }
    }

    @Override
    public List<Book> finAll() {
        return factory
                .openSession()
                .createCriteria(Autor.class)
                .list();
    }
}
