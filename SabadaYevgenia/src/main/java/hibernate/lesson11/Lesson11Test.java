package hibernate.lesson11;

import hibernate.lesson11.entiy.Emploee;
import hibernate.lesson11.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Lesson11Test {

    public static void main(String[] args) {

        Emploee employee1 = new Emploee(
                "Igor",
                "Ivanov",
                45,
                "Cleaner",
                1000.00

        );

        Emploee employee2 = new Emploee(
                "Valentin",
                "Ivanov",
                55,
                "Director",
                1500.00

        );
        Session session =
                HibernateUtil.getFactory().openSession();
        try {
            session.beginTransaction();
            session.save(employee1);
            session.save(employee2);
            session.getTransaction().commit();
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
        }

        HibernateUtil.getFactory().close();
    }
}
