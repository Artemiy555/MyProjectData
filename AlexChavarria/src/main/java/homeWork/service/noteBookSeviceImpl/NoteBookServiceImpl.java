package homeWork.service.noteBookSeviceImpl;

import homeWork.dao.NoteBookDao;
import homeWork.entity.NoteBook;
import homeWork.entity.subEntity.Cpu;
import homeWork.entity.subEntity.Memory;
import homeWork.entity.subEntity.Vendor;
import homeWork.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    private NoteBookDao dao;

    @Override
    public NoteBook create(List<Cpu> cpuList,
                           List<Memory> memoryList,
                           List<Vendor> vendorList,
                           NoteBook partyRoomId,
                           Double price,
                           Date manufactureDate) {
        NoteBook noteBook = new NoteBook(cpuList,memoryList,vendorList,price,manufactureDate);
        noteBook.setId(dao.create(noteBook));
        return noteBook;
    }

    @Override
    public NoteBook findById(Long id) {
        if (id != null){
            return dao.read(id);
        }
        return null;
    }

    @Override
    public void update(NoteBook noteBook) {
        if (dao.update(noteBook)){
            System.out.println("update success");
            return;
        }
        System.out.println("update fail");
    }

    @Override
    public void delete(NoteBook noteBook) {
        if (dao.delete(noteBook)){
            System.out.println("delete success");
            return;
        }
        System.out.println("delete fail");
    }

    @Override
    public List<NoteBook> findAll() {
        return dao.findAll();
    }

}
