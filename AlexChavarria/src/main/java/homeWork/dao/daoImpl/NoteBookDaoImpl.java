package homeWork.dao.daoImpl;

import homeWork.dao.NoteBookDao;
import homeWork.entity.NoteBook;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NoteBookDaoImpl implements NoteBookDao {
    @Autowired
    private SessionFactory factory;


    @Override
    public Long create(NoteBook noteBook) {
        return (Long) factory
                .getCurrentSession()
                .save(noteBook);
    }

    @Override
    public NoteBook read(Long id) {
        return factory
                .getCurrentSession()
                .get(NoteBook.class, id);
    }

    @Override
    public boolean update(NoteBook noteBook) {
        factory.getCurrentSession().saveOrUpdate(noteBook);
        return true;
    }

    @Override
    public boolean delete(NoteBook noteBook) {
        factory.getCurrentSession().delete(noteBook);
        return true;
    }

    @Override
    public List<NoteBook> findAll() {
        return factory.getCurrentSession().createCriteria(NoteBook.class).list();
    }
}
