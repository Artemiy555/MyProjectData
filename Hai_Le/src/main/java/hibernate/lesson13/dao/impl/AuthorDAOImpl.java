package hibernate.lesson13.dao.impl;

import hibernate.lesson13.dao.AuthorDAO;
import hibernate.lesson13.entity.Author;
import hibernate.lesson13.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public class AuthorDAOImpl implements AuthorDAO {
    //Создаем сешнфактори
    private SessionFactory factory;

    public AuthorDAOImpl() {factory = HibernateUtil.getFactory();}


    @Override
    public Long create(Author author) {
        //созданием сессии
        Session session = factory.openSession();
        try {
            /*
                Открываем транзакцию, получаем ID нашего
                Автора, коммитим транзакцию, возвращаем ID
                Запись создана, сощность записана в БД
            */
            session.beginTransaction();
            Long id = (Long) session.save(author);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            /*
                Если ловим ошибку, возращаем значения и
                выводим ошибку
             */
            session.getTransaction().rollback();
            System.err.println("Error : " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Author read(long id) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            // получаем запись типа Author по его ID
            return session.get(Author.class, id);
        } catch (HibernateException e) {
            System.err.println("Error : [ID:" + id + "] is incorrect!");
            return null;
        }
    }

    @Override
    public boolean update(Author author) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            //Обновляем Author
            session.update(author);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.err.println("Error to update!");
            return false;
        }
    }

    @Override
    public boolean delete(Author author) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(author);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            System.err.println("Error to delete!");
            return false;
        }
    }

    @Override
    public List<Author> findAll() {
        //Получение всего списка
        return factory
                .openSession()
                .createCriteria(Author.class)
                .list();
    }
}
