package homeWork.service.subService.subServiceImpl;

import homeWork.dao.subDao.MemoryDao;
import homeWork.entity.subEntity.Memory;
import homeWork.service.subService.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemoryServiceImpl implements MemoryService {
    @Autowired
    private MemoryDao dao;

    @Override
    public Memory create(String memoryFrequency, String memoryType, String memorySize) {
        Memory memory = new Memory(memoryType, memoryFrequency, memorySize);
        memory.setId(dao.create(memory));
        return memory;
    }

    @Override
    public Memory findById(Long id) {
        if (id != null) {
            return dao.read(id);
        }
        return null;
    }

    @Override
    public void update(Memory memory) {
        if (dao.update(memory)) {
            System.out.println("Обновление прошло успешно");
            return;
        }
        System.out.println("Обновление не удалось");
    }

    @Override
    public void delete(Memory memory) {
        if (dao.delete(memory)) {
            System.out.println("Удаление прошло успешно");
            return;
        }
        System.out.println("Удаление не удалось");
    }

    @Override
    public List<Memory> findAll() {
        return dao.findAll();
    }
}
