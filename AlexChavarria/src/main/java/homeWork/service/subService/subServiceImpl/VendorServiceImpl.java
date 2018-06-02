package homeWork.service.subService.subServiceImpl;

import homeWork.dao.subDao.VendorDao;
import homeWork.entity.NoteBook;
import homeWork.entity.subEntity.Vendor;
import homeWork.service.subService.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService{
    @Autowired
    private VendorDao dao;

    @Override
    public Vendor create( String name, String description) {
        Vendor vendor = new Vendor(name,description);
        vendor.setId(dao.create(vendor));
        return vendor;
    }



    @Override
    public Vendor findById(Long id) {
        if (id != null) {
            return dao.read(id);
        }
        return null;
    }

    @Override
    public void update(Vendor vendor) {
        if (dao.update(vendor)) {
            System.out.println("Обновление прошло успешно");
            return;
        }
        System.out.println("Обновление не удалось");
    }

    @Override
    public void delete(Vendor vendor) {
        if (dao.delete(vendor)) {
            System.out.println("Удаление прошло успешно");
            return;
        }
        System.out.println("Удаление не удалось");
    }

    @Override
    public List<Vendor> findAll() {
        return dao.findAll();
    }
}
