package hybernate.lesson14.dao;

import hybernate.lesson14.entity.Group;

import java.util.List;

public interface GroupDAO {

    Long create(Group group);

    Group read(Long id);

    boolean update(Group group);

    boolean delete(Long id);

    List<Group> findAll();
}
