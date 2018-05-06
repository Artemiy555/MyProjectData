package hibernate.lesson11.practic;

import hibernate.lesson11.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Test {
    public static void main(String[] args) {
        Phone phone1 = new Phone("Apple", "Iphone 7", 2016);
        Phone phone2 = new Phone("Apple", "Iphone 8", 2017);
        Session session = HibernateUtil.getFactory().openSession();
        try{
            session.beginTransaction();
            session.save(phone1);
            session.save(phone2);
            session.getTransaction().commit();
        }catch (HibernateException ex){
            session.getTransaction().rollback();
        }

    Sim sim1 = new Sim("Vodafone", "RED M");
    Sim sim2 = new Sim("Kievstar", "FREE");
        try{
        session.beginTransaction();
        session.save(sim1);
        session.save(sim2);
        session.getTransaction().commit();
    }catch (HibernateException ex){
        session.getTransaction().rollback();
    }
        HibernateUtil.getFactory().close();
}
}


