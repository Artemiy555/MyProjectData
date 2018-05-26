package hibernate.lesson14.dao.impl;

import hibernate.lesson14.util.HibernateUtil;
import hibernate.lesson14.dao.GroupDAO;
import hibernate.lesson14.entity.Group;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GroupDAOImpl implements GroupDAO {

    private SessionFactory factory;

    public GroupDAOImpl() {
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Group group) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(group);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Group read(Long id) {
        return null;
    }

    @Override
    public boolean update(Group group) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Group> findAll() {
        return null;
    }
}
