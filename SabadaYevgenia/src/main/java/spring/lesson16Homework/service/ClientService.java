package spring.lesson16Homework.service;

import spring.lesson16Homework.entity.Client;

import java.util.Date;
import java.util.List;

public interface ClientService {
    Client create(String fullName, String phone, String email, String discount);
    Client findById(Long id);
    void update(Client client);
    void delete(Client client);
    List<Client> finfAll();
}
