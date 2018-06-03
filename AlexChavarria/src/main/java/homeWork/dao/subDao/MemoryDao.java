package homeWork.dao.subDao;


import homeWork.entity.subEntity.Memory;

import java.util.List;

public interface MemoryDao {

    Long create(Memory memory);

    Memory read(Long id);

    boolean update(Memory memory);

    boolean delete(Memory memory);

    List<Memory> findAll();
}
