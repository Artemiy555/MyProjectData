package hibernate.lesson14.dao.impl;

import hibernate.lesson14.dao.CroupDao;
import hibernate.lesson14.entity.Croup;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CroupDaoImpl implements CroupDao {

    private SessionFactory factory;

    public CroupDaoImpl() { }

    public CroupDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Long create(Croup croup) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            Long id=(Long)session.save(croup);
            session.getTransaction().commit();
            return id;
        }catch (HibernateException exc){
            return null;
        }
    }

    @Override
    public Croup read(Long id) {
        return null;
    }

    @Override
    public boolean update(Croup croup) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Croup> findAll() {
        return null;
    }
}
