package homeWork.service.subService;

import homeWork.entity.subEntity.Memory;

import java.util.List;

public interface MemoryService {

    Memory create (String memoryType, String memoryFrequency, String memorySize);

    Memory findById(Long id);

    void update(Memory memory);

    void delete(Memory memory);

    List<Memory> findAll();
}
