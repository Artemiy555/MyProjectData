package homeWork.service;

import homeWork.entity.NoteBook;
import homeWork.entity.subEntity.Cpu;
import homeWork.entity.subEntity.Memory;
import homeWork.entity.subEntity.Vendor;

import java.util.Date;
import java.util.List;

public interface NoteBookService {

    NoteBook create(List<Cpu> cpuList,
                    List<Memory> memoryList,
                    List<Vendor> vendorList,
                    NoteBook partyRoomId,
                    Double price,
                    Date manufactureDate);

    NoteBook findById(Long id);

    void update(NoteBook noteBook);

    void delete(NoteBook noteBook);

    List<NoteBook> findAll();
}
