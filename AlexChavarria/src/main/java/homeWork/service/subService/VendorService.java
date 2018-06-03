package homeWork.service.subService;

import homeWork.entity.NoteBook;
import homeWork.entity.subEntity.Vendor;

import java.util.List;

public interface VendorService {
    Vendor create (String name, String description);

    Vendor findById(Long id);

    void update(Vendor vendor);

    void delete(Vendor vendor);

    List<Vendor> findAll();
}
