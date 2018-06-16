package spring.lesson16Homework.dao;

import spring.lesson16Homework.entity.Client;

import java.util.List;

public interface ClientDao {

    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete (Client client);

    List<Client> findAll();

}
