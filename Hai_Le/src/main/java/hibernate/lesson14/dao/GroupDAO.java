package hibernate.lesson14.dao;


import hibernate.lesson14.entity.Group;

import java.util.List;

public interface GroupDAO {

    Long create(Group group);

    Group read(Long id);

    boolean update(Group course);

    boolean delete(Long id);

    List<Group> findAll();

}