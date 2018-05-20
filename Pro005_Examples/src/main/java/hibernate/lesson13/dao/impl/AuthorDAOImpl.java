package hibernate.lesson13.dao.impl;

import hibernate.lesson13.dao.AuthorDAO;
import hibernate.lesson13.entity.Author;
import hibernate.lesson13.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {

    private SessionFactory factory;

    public AuthorDAOImpl() {
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Author author) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(author);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
            System.out.println("Error : " + exc.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Author read(Long id) {
        try (Session session = factory.openSession()) {
            return session.get(Author.class, id);
        } catch (HibernateException exc) {
            System.out.println("Error! Incorrect [ID: " + id + "].");
            return null;
        }
    }

    @Override
    public boolean update(Author author) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(author);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException exc) {
            session.getTransaction().rollback();
            System.out.println("Error! Update fail...");
            return false;
        }
    }

    @Override
    public boolean delete(Author author) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
            return true;
        }
        catch (HibernateException exc) {
            session.getTransaction().rollback();
            System.out.println("Error! Delete fail...");
            return false;
        }
    }

    @Override
    public List<Author> findAll() {
        return factory
                .openSession()
                .createCriteria(Author.class)
                .list();
    }
}
