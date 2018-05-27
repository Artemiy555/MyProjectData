package hibernate.lesson11Task.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtilTask {


    private  static  final SessionFactory factory = build();
    private static StandardServiceRegistry registry;

    private static SessionFactory build(){
        registry = new StandardServiceRegistryBuilder()
                .configure("lesson11/hibernate.cfg.xml")
                .build();
        return new MetadataSources(registry)
                .buildMetadata()
                .buildSessionFactory();
    }

    public static SessionFactory getFactory(){
        return factory;
    }
}
