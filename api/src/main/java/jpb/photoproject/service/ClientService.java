package jpb.photoproject.service;

import jpb.photoproject.classes.Client;
import jpb.photoproject.dao.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientDAO clientDAO;

    public List<Client> findAll() {
        return this.clientDAO.findAll();
    }
}
