package hibernate.lesson14.dao;

import hibernate.lesson14.entity.Croup;

import java.util.List;

public interface CroupDao {

    Long create(Croup croup);
    Croup read(Long id);
    boolean update(Croup croup);
    boolean delete(Long id);
    List<Croup> findAll();
}