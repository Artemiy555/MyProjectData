package group.dao.impl;

import group.dao.RatingFirstCourseDao;
import group.entily.RatingFirstCourse;
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

public class RatingFirstCourseDAOImpl implements RatingFirstCourseDao {
    private SessionFactory factory;


    public RatingFirstCourseDAOImpl() {
        factory = HibernateUtil.getFactory();
    }

    @Override
    public Long create(RatingFirstCourse ratingSecondCourse) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(ratingSecondCourse);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException exc) {
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public RatingFirstCourse read(Long id) {
        Session session = factory.openSession();
        RatingFirstCourse ratingSecondCourse = session.get(RatingFirstCourse.class, id);
        session.close();
        return ratingSecondCourse;
    }

    @Override
    public boolean update(RatingFirstCourse ratingSecondCourse) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
    private static String url  =
            "jdbc:mysql://localhost:3306/hibernate?useSSL=false";//Подключение БД
    private static String user = "root";
    private static String pass = "root";
    @Override
    public List<RatingFirstCourse> findAll() {
        Locale.setDefault(Locale.ENGLISH);
        try (Connection c =
                     DriverManager.getConnection(url, user, pass)) {
            Statement statement = c.createStatement();
            /* ResultSet - множество записей которые мы получим
            из БД, (не обработанные)*/
            ResultSet set = statement.executeQuery(
                    "SELECT * FROM rating_first_course"
            );

            List<RatingFirstCourse> doctors = new ArrayList<>();
            while (set.next()) {
                doctors.add(new RatingFirstCourse(
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
//
    }

}
