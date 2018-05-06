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

        Order order1 =
                new Order(ProductType.FISH, 2, 28.50,
                        Calendar.getInstance().getTime());
        Order order2 =
                new Order(ProductType.BREAD, 10, 1.50,
                        Calendar.getInstance().getTime());
        Order order3 =
                new Order(ProductType.PINEAPPLE, 5, 5.25,
                        Calendar.getInstance().getTime());

        session.beginTransaction();
        session.save(order1);
        session.save(order2);
        session.save(order3);
        session.getTransaction().commit();

        List<Order> orders =
                HibernateUtil.getFactory().openSession()
                        .createCriteria(Order.class)
                        .list();

        for (Order order : orders) {
            System.out.println(order);
        }

        HibernateUtil.getFactory().close();
    }
}
