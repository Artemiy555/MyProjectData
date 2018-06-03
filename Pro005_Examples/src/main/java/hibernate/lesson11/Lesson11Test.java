package hibernate.lesson11;

import hibernate.lesson11.entity.Employee;
import hibernate.lesson11.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Lesson11Test {
    public static Employee createEmp() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1st");
        Employee employee1 = new Employee(
                reader.readLine(), //name
                reader.readLine(), // surname
                new Integer(reader.readLine()), //age
                reader.readLine(), //position
                new Double(reader.readLine()) //salary
        );
            return employee1;
    }




    public static void main(String[] args) throws Exception {
       Employee employee = createEmp();


        Session session = HibernateUtil.getFactory().openSession();
        try {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        } catch (HibernateException exc) {
            session.getTransaction().rollback();
        }

        HibernateUtil.getFactory().close();

    }


    }

