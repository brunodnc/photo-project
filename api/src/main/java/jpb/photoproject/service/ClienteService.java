package jpb.photoproject.service;

import jpb.photoproject.dao.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteDAO clienteDAO;

    public List<Object> recuperar() {
        return this.clienteDAO.recuperarTodos();
    }
}
