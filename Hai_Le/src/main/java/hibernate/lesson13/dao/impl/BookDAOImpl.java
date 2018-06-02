package hibernate.lesson13.dao.impl;

import hibernate.lesson13.dao.BookDAO;
import hibernate.lesson13.entity.Book;
import hibernate.lesson13.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDAOImpl implements BookDAO {

    private SessionFactory factory;

    public BookDAOImpl() {factory = HibernateUtil.getFactory();}


    @Override
    public Long create(Book book) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(book);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            System.err.println("Creating Error! \n" + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Book read(long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            return session.get(Book.class, id);
        } catch (HibernateException e) {
            System.err.println("Reading Error!");
            return null;
        }
    }

    @Override
    public boolean update(Book book) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.err.println("Update Error!");
            return false;
        }

    }

    @Override
    public boolean delete(Book book) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.err.println("Delete Error!");
            return false;
        }
    }

    @Override
    public List<Book> findAll() {
        return factory
                .openSession()
                .createCriteria(Book.class)
                .list();
    }
}
