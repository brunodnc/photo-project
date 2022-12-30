package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpb.photoproject.classes.Photographer;
import jpb.photoproject.repository.PhotographerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotographerDAO {

    /**
     * jpa
     */
    @Autowired
    private PhotographerRepository photographerRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Photographer> findAll() {
        return this.photographerRepository.findAll();
    }
}
