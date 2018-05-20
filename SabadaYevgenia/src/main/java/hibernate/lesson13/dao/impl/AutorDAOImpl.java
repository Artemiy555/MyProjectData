package hibernate.lesson13.dao.impl;

import hibernate.lesson13.dao.AuthorDao;
import hibernate.lesson13.entity.Autor;
import hibernate.lesson13.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AutorDAOImpl implements AuthorDao {
private SessionFactory factory;
public AutorDAOImpl(){factory= HibernateUtil.getFactory();}

@Override
public Long create (Autor autor){
    Session session=factory.openSession();
            try{
        session.beginTransaction();
        Long id=(Long)session.save(autor);
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
    public boolean updete(Autor autor) {
    Session session=factory.openSession();
    try{
        session.beginTransaction();
        session.update(autor);
        session.getTransaction().commit();
        return true;

    }catch (HibernateException exc){
        session.getTransaction().rollback();
        System.out.println("Error!Update fail...");
        return false;
    }
    }

    @Override
    public boolean delete(Autor autor) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(autor);
            session.getTransaction().commit();
            return true;

        }catch (HibernateException exc){
            session.getTransaction().rollback();
            System.out.println("Error!Delet fail...");
            return false;
        }
    }

    @Override
    public List<Autor> finAll() {
        return factory
                .openSession()
                .createCriteria(Autor.class)
                .list();
    }
}
