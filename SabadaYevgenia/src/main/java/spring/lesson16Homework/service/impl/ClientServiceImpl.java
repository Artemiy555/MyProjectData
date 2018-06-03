package spring.lesson16Homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import spring.lesson16Homework.dao.ClientDao;
import spring.lesson16Homework.entity.Client;
import spring.lesson16Homework.service.ClientService;

import java.util.Date;
import java.util.List;

public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao dao;


    @Override
    public Client create(String fullName, String phone, String email, String discount) {
        Client client=new Client(fullName, phone, email, discount);
        client.setId(dao.create(client));
        return client;
    }

    @Override
    public Client findById(Long id) {
        return null;
    }

    @Override
    public void update(Client client) {

    }

    @Override
    public void delete(Client client) {

    }

    @Override
    public List<Client> finfAll() {
        return null;
    }
}
