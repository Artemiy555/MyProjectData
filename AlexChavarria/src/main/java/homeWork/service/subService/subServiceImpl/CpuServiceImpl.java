package homeWork.service.subService.subServiceImpl;

import homeWork.dao.subDao.CPUDao;
import homeWork.entity.subEntity.Cpu;
import homeWork.service.subService.CpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class CpuServiceImpl implements CpuService {
    @Autowired
    private CPUDao dao;

    @Override
    public Cpu create(String model, String cpuFrequency) {
        Cpu cpu = new Cpu(model, cpuFrequency);
        cpu.setId(dao.create(cpu));
        return cpu;
    }

    @Override
    public Cpu findById(Long id) {
        if (id != null) {
            return dao.read(id);
        }
        return null;
    }

    @Override
    public void update(Cpu cpu) {
        if (dao.update(cpu)) {
            System.out.println("Обновление прошло успешно");
            return;
        }
        System.out.println("Обновление не удалось");
    }

    @Override
    public void delete(Cpu cpu) {
        if (dao.delete(cpu)) {
            System.out.println("Удаление прошло успешно");
            return;
        }
        System.out.println("Удаление не удалось");
    }

    @Override
    public List<Cpu> findAll() {
        return dao.findAll();
    }
}
