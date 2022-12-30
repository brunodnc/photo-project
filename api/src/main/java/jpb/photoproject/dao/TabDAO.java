package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TabDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Object> recuperarTodos() {
        return this.em.createNativeQuery("SELECT * FROM tab").getResultList();
    }
}
