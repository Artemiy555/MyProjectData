package homeWork.service.subService;

import homeWork.entity.subEntity.Cpu;

import java.util.List;

public interface CpuService {

    Cpu create (String cpuMark, String cpuFrequency);

    Cpu findById(Long id);

    void update(Cpu cpu);

    void delete(Cpu cpu);

    List<Cpu> findAll();

}
