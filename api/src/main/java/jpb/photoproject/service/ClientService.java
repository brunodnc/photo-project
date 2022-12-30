package jpb.photoproject.service;

import jpb.photoproject.classes.Client;
import jpb.photoproject.dao.ClientDAO;
import jpb.photoproject.helper.HibernateHelper;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    /**
     * dao
     */
    @Autowired
    private ClientDAO clientDAO;

    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true, isolation = Isolation.SERIALIZABLE, rollbackFor = Exception.class)
    public List<Client> findAll(final boolean lazyLoad) {
        final List<Client> clients = this.clientDAO.findAll();
        if (lazyLoad) HibernateHelper.initializeAll(clients);
        else HibernateHelper.clearAllLazy(clients);
        return clients;
    }
}
