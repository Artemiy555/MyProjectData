package group.dao.impl;

import group.dao.StudentDao;
import group.entily.Student;
import group.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAOImpl implements StudentDao {
    private SessionFactory factory;

    public StudentDAOImpl() {
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Student student) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(student);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Student read(Long id) {
        Session session = factory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    @Override
    public boolean update(Student group) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Student> findAll() {
        List<Student> list = factory.openSession().createCriteria(Student.class).list();

        return list;
    }

}
