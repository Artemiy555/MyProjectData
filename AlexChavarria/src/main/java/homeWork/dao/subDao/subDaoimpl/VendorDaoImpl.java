package homeWork.dao.subDao.subDaoimpl;

import homeWork.dao.subDao.VendorDao;
import homeWork.entity.subEntity.Vendor;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VendorDaoImpl implements VendorDao {

    @Autowired
    private SessionFactory factory;


    @Override
    public Long create(Vendor vendor) {
        return (Long) factory
                .getCurrentSession()
                .save(vendor);
    }

    @Override
    public Vendor read(Long id) {
        return factory
                .getCurrentSession()
                .get(Vendor.class, id);
    }

    @Override
    public boolean update(Vendor vendor) {
        factory.getCurrentSession().saveOrUpdate(vendor);
        return true;
    }

    @Override
    public boolean delete(Vendor vendor) {
        factory.getCurrentSession().delete(vendor);
        return true;
    }

    @Override
    public List<Vendor> findAll() {
        return factory.getCurrentSession().createCriteria(Vendor.class).list();
    }
}
