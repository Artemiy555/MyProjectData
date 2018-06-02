package homeWork.dao.subDao.subDaoimpl;

import homeWork.dao.subDao.MemoryDao;
import homeWork.entity.subEntity.Memory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MemoryDaoImpl implements MemoryDao {
    @Autowired
    private SessionFactory factory;


    @Override
    public Long create(Memory memory) {
        return (Long) factory
                .getCurrentSession()
                .save(memory);
    }

    @Override
    public Memory read(Long id) {
        return factory
                .getCurrentSession()
                .get(Memory.class, id);
    }

    @Override
    public boolean update(Memory memory) {
        factory.getCurrentSession().saveOrUpdate(memory);
        return true;
    }

    @Override
    public boolean delete(Memory memory) {
        factory.getCurrentSession().delete(memory);
        return true;
    }

    @Override
    public List<Memory> findAll() {
        return factory.getCurrentSession().createCriteria(Memory.class).list();
    }
}
