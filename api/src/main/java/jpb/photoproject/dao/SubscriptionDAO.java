package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpb.photoproject.classes.Subscription;
import jpb.photoproject.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriptionDAO {

    /**
     * jpa
     */
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Subscription> findAll() {
        return this.subscriptionRepository.findAll();
    }
}
