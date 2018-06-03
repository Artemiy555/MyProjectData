package hibernate.lesson12;

import hibernate.lesson12.entity.Order;
import hibernate.lesson12.entity.types.ProductType;
import hibernate.lesson12.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.List;

public class Lesson12Test {

    public static void main(String[] args) {
        Session session = HibernateUtil.getFactory().openSession();

        Order order1 = new Order(ProductType.MILK, 21, 28.50,
                Calendar.getInstance().getTime());
        Order order2 = new Order(ProductType.MEAT, 11, 1.50,
                Calendar.getInstance().getTime());
        Order order3 = new Order(ProductType.PINEAPPLE, 15, 5.25,
                Calendar.getInstance().getTime());
        Order order4 = new Order(ProductType.BREAD, 16, 283.50,
                Calendar.getInstance().getTime());
        Order order5 = new Order(ProductType.FISH, 27, 218.50,
                Calendar.getInstance().getTime());


        session.beginTransaction();
        session.save(order1);
        session.save(order2);
        session.save(order3);
        session.save(order4);
        session.save(order5);
        session.getTransaction().commit();


        HibernateUtil.getFactory().close();
    }
}
