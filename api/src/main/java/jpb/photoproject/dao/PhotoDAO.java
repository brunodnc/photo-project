package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpb.photoproject.classes.Photo;
import jpb.photoproject.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhotoDAO {

    /**
     * jpa
     */
    @Autowired
    private PhotoRepository photoRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Photo> findAll() {
        return this.photoRepository.findAll();
    }
}
