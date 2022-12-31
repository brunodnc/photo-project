package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpb.photoproject.classes.Tab;
import jpb.photoproject.repository.TabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TabDAO {

    /**
     * jpa
     */
    @Autowired
    private TabRepository tabRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Tab> findAll() {
        return this.tabRepository.findAll();
    }

    public Tab postTab(Tab tab) { return this.tabRepository.save(tab); }
}
