package homeWork.dao;

import homeWork.entity.NoteBook;

import java.util.List;

public interface NoteBookDao {

    Long create (NoteBook noteBook);

    NoteBook read (Long id);

    boolean update(NoteBook noteBook);

    boolean delete(NoteBook noteBook);

    List<NoteBook> findAll();
}
