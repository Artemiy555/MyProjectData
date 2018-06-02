package hybernate.lesson13.dao.impl;


import hybernate.lesson13.dao.BookDAO;
import hybernate.lesson13.entity.Author;
import hybernate.lesson13.entity.Book;
import hybernate.lesson13.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDAOimpl implements BookDAO {

    private SessionFactory factory;

    public BookDAOimpl(){
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Book book) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(book);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            System.out.println("Error : " + exc.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Book read(Long id) {
        try {
            Session session = factory.openSession();
            return session.get(Book.class, id);
        } catch (HibernateException exc) {
            System.out.println("Error! [ID: " + id + "].");
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

        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            System.out.println("Error! Update fail...");

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

        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            System.out.println("Error! Delete fail...");

            return false;
        }

    }

    @Override
    public List<Book> findAll () {
        return factory.openSession()
                .createCriteria(Book.class)
                .list();

    }


}
