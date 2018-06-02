package homeWork;

import homeWork.entity.subEntity.Cpu;
import homeWork.entity.subEntity.Memory;
import homeWork.entity.subEntity.Vendor;
import homeWork.service.NoteBookService;
import homeWork.service.subService.CpuService;
import homeWork.service.subService.MemoryService;
import homeWork.service.subService.VendorService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeWorkTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("homeWork/hibernate.cfg.xml");


        CpuService cpuService = context.getBean(CpuService.class);


        MemoryService memoryService = context.getBean(MemoryService.class);
        VendorService vendorService = context.getBean(VendorService.class);
        NoteBookService noteBookService = context.getBean(NoteBookService.class);







    }
}
