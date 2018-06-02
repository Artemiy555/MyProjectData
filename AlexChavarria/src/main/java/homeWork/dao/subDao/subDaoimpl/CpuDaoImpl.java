package homeWork.dao.subDao.subDaoimpl;

import homeWork.dao.subDao.CPUDao;
import homeWork.entity.subEntity.Cpu;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class CpuDaoImpl implements CPUDao {

    @Autowired
    private SessionFactory factory;


    @Override
    public Long create(Cpu cpu) {
        return (Long) factory
                .getCurrentSession()
                .save(cpu);
    }

    @Override
    public Cpu read(Long id) {
        return factory
                .getCurrentSession()
                .get(Cpu.class, id);
    }

    @Override
    public boolean update(Cpu cpu) {
        factory.getCurrentSession().saveOrUpdate(cpu);
        return true;
    }

    @Override
    public boolean delete(Cpu cpu) {
        factory.getCurrentSession().delete(cpu);
        return true;
    }

    @Override
    public List<Cpu> findAll() {
        return factory.getCurrentSession().createCriteria(Cpu.class).list();
    }
}
