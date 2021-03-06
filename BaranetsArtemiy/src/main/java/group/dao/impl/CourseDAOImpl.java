package group.dao.impl;

import group.dao.CourseDao;
import group.entily.Course;
import group.entily.Group;
import group.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CourseDAOImpl implements CourseDao {

    private SessionFactory factory;

    public CourseDAOImpl() {
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(Course course) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(course);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public Course read(Long id) {
        Session session = factory.openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    @Override
    public boolean update(Course course) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(course);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean delete(Course course) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(course);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException exc) {
            return false;
        } finally {
            session.close();
        }
    }
    private static String url  =
            "jdbc:mysql://localhost:3306/hibernate?useSSL=false";//Подключение БД
    private static String user = "root";
    private static String pass = "root";
    @Override
    public List<Course> findAll() {
        Locale.setDefault(Locale.ENGLISH);
        try (Connection c =
                     DriverManager.getConnection(url, user, pass)) {
            Statement statement = c.createStatement();
            /* ResultSet - множество записей которые мы получим
            из БД, (не обработанные)*/
            ResultSet set = statement.executeQuery(
                    "SELECT * FROM courses"
            );

            List<Course> doctors = new ArrayList<>();
            while (set.next()) {
                doctors.add(new Course(
                        set.getLong(1),
                        set.getString(2),
                        set.getString(3)


                ));
            }
            statement.close();
            return  doctors;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
//        List<Course> list = factory.openSession().createCriteria(Course.class).list();
//
//        return list;
    }
}

