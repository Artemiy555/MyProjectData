package homeWork.dao.subDao;

import homeWork.entity.subEntity.Cpu;

import java.util.List;

public interface CPUDao {

    Long create(Cpu cpu);

    Cpu read(Long id);

    boolean update(Cpu cpu);

    boolean delete(Cpu cpu);

    List<Cpu> findAll();

}
