package jpb.photoproject.service;

import jpb.photoproject.classes.Tab;
import jpb.photoproject.dao.TabDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabService {

    /**
     * dao
     */
    @Autowired
    private TabDAO tabDAO;

    public List<Tab> findAll() {
        return this.tabDAO.findAll();
    }

    public Tab findById(Long id) { return this.tabDAO.findById(id); }

    public Tab postTab(Tab tab) { return this.tabDAO.postTab(tab); }

    public List<Tab> findByClientId(Long clientId) { return this.tabDAO.findByClientId(clientId); }
}
