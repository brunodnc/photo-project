package jpb.photoproject.service;

import jpb.photoproject.classes.Photo;
import jpb.photoproject.dao.PhotoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    /**
     * dao
     */
    @Autowired
    private PhotoDAO photoDAO;


    public List<Photo> findAll() {
        return this.photoDAO.findAll();
    }
}
