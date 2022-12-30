package jpb.photoproject.service;

import jpb.photoproject.classes.Tab;
import jpb.photoproject.dao.ClientDAO;
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
}
