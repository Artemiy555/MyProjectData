package group.dao.impl;


import group.dao.GroupDao;
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

public class GroupDAOImpl implements GroupDao {

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
        Session session = factory.openSession();
        Group group = session.get(Group.class, id);
        session.close();
        return group;
    }

    @Override
    public boolean update(Group group) {
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
    public List<Group> findAll() {
//        Locale.setDefault(Locale.ENGLISH);
//        try (Connection c =
//                     DriverManager.getConnection(url, user, pass)) {
//            Statement statement = c.createStatement();
//            /* ResultSet - множество записей которые мы получим
//            из БД, (не обработанные)*/
//            ResultSet set = statement.executeQuery(
//                    "SELECT * FROM groups"
//            );
//
//            List<Group> doctors = new ArrayList<>();
//            while (set.next()) {
//                doctors.add(new Group(
//                        set.getLong(1),
//                        set.getDate(2),
//                        set.getDate(3),
//                        set.getString(4)
//                ));
//            }
//            statement.close();
//            return  doctors;
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
        List<Group> list = factory.openSession().createCriteria(Group.class).list();

        return list;
    }
}
