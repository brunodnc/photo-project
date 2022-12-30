package jpb.photoproject.service;

import jpb.photoproject.classes.Subscription;
import jpb.photoproject.dao.SubscriptionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {

    /**
     * dao
     */
    @Autowired
    private SubscriptionDAO subscriptionDAO;


    public List<Subscription> findAll() {
        return this.subscriptionDAO.findAll();
    }
}
