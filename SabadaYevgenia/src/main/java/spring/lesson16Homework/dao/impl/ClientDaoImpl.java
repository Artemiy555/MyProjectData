package spring.lesson16Homework.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spring.lesson16Homework.dao.ClientDao;
import spring.lesson16Homework.entity.Client;

import java.util.List;

@Repository
@Transactional
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private SessionFactory factory;

    @Override
    public Long create(Client client) {
        return (Long) factory
                .getCurrentSession()
                .save(client);
    }

    @Override
    public Client read(Long id) {
        return factory
                .getCurrentSession().get(Client.class, id);
    }

    @Override
    public boolean update(Client client) {
        factory
                .getCurrentSession()
                .saveOrUpdate(client);
        return true;
    }

    @Override
    public boolean delete(Client client) {
        factory
                .getCurrentSession()
                .delete(client);
        return true;
    }

    @Override
    public List<Client> findAll() {
        return factory
                .getCurrentSession().createCriteria(Client.class)
                .list();
    }
}
