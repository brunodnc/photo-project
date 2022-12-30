package jpb.photoproject.service;

import jpb.photoproject.classes.Photographer;
import jpb.photoproject.dao.PhotographerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotographerService {

    /**
     * dao
     */
    @Autowired
    private PhotographerDAO photographerDAO;


    public List<Photographer> findAll() {
        return this.photographerDAO.findAll();
    }
}
