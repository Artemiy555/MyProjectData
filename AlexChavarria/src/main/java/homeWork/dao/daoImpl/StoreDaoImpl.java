package homeWork.dao.daoImpl;

import homeWork.dao.StoreDao;
import homeWork.entity.Store;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StoreDaoImpl implements StoreDao {
    @Autowired
    private SessionFactory factory;


    @Override
    public Long create(Store store) {
        return (Long) factory
                .getCurrentSession()
                .save(store);
    }

    @Override
    public Store read(Long id) {
        return factory
                .getCurrentSession()
                .get(Store.class, id);
    }

    @Override
    public boolean update(Store store) {
        factory.getCurrentSession().saveOrUpdate(store);
        return true;
    }

    @Override
    public boolean delete(Store store) {
        factory.getCurrentSession().delete(store);
        return true;
    }

    @Override
    public List<Store> findAll() {
        return factory.getCurrentSession().createCriteria(Store.class).list();
    }
}
