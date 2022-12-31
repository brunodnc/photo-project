package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpb.photoproject.classes.Client;
import jpb.photoproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ClientDAO {

    /**
     * jpa
     */
    @Autowired
    private ClientRepository clientRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }

    public List<Client> findAllByPhotographerId(Long photographerId) { return this.clientRepository.findAll(// query
      );
    }

    public Client postClient(Client client) { return this.clientRepository.save(client); }
}
