package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpb.photoproject.classes.Client;
import jpb.photoproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ClientRepository clientRepo;

    public List<Client> findAll(){
        return this.clientRepo.findAll();
    }
}
