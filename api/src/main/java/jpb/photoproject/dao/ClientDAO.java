package jpb.photoproject.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jpb.photoproject.classes.Client;
import jpb.photoproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ClientDAO {

    /**
     * jpa
     */
    @Autowired
    private ClientRepository clientRepository;

    @PersistenceContext
    private EntityManager em;

    public List<Client> findAll() {
        return this.clientRepository.findAll();
    }


    public List<Client> findByPhotographerId(Long photographerId) { return this.clientRepository.findByPhotographerId(photographerId);
    }

    public Client postClient(Client client) { return this.clientRepository.save(client); }


    /**
     * É POSSÍVEL CRIAR QUERIES NATIVAS DA LINGUAGEM ESPECÍFICA, NO CASO SQL
     * PORTANTO PODE CRIAR QUALQUER SCRIPT QUE FUNCIONE NO SGBD
     *
     * @return
     */
    public List<Client> findNativeSQL() {

        //OS PARÂMETROS DE COMPARAÇÃO DEVEM SER PASSADOR COM :. Ex: :data; :id, etc.
        //É POSSÍVEL UTILIZAR TODOS OS CRITÉRIOS DA LINGUAGEM DE SCRIPT. EX: WHERE IN (:range)
        final Query query = this.em.createNativeQuery("SELECT * FROM client WHERE created_at = :data");

        //SEMPRE UTILIZAR DESSA FORMA, PASSANDO OS PARAMETROS ATRAVÉS DESSE MÉTODO, POIS O JPA FAZ A TRATATIVA PARA REMOVER
        //POSSÍVEIS INJEÇÕES DE SQL
        query.setParameter("data", new Date());
        return query.getResultList();
    }


    /**
     * AQUI É UTILIZADA A LINGUAGEM JQL (JPA QUERY LANGUAGE), OU HQL (HIBERNATE QUERY LANGUAGE)
     * JPA É A ESPECIFICAÇÃO E  HIBERNATE É O FRAMEWORK QUE IMPLEMENTA JPA
     * NOTA-SE QUE NAS JQL/HQL DEVE-SE INFORMAR O NOME DA ENTIDADE E ATRIBUTOS NO JAVA, NÃO DO BANCO. EX:
     * SUPONHA QUE A TABELA Client NO BANCO SEJA tb_client, PORÉM NO JAVA A ENTIDADE SE CHAMA Client, PORTANTO
     * NA QUERY VOCÊ DEVE INFORMAR Client, CASO FOSSE QUERY NATIVA, DEVERIA SER tb_client.
     * MESMA COISA PARA AS COLUNAS, created_at DEVE SER PASSADA COMO createdAt, POIS ESTÁ MAPEADA ASSIM NA CLASSE Client
     *
     * @return
     */
    public Client findJQL() {

        //OS PARÂMETROS DE COMPARAÇÃO DEVEM SER PASSADOR COM :. Ex: :data; :id, etc.
        //NA JQL/HQL É POSSÍVEL UTILIZAR ALGUNS CRITÉRIOS DA LINGUAGEM DE SCRIPT. EX: WHERE IN (:range)
        final Query query = this.em.createQuery("FROM Client WHERE createdAt = :data");

        //SEMPRE UTILIZAR DESSA FORMA, PASSANDO OS PARAMETROS ATRAVÉS DESSE MÉTODO, POIS O JPA FAZ A TRATATIVA PARA REMOVER
        //POSSÍVEIS INJEÇÕES DE SQL
        query.setParameter("data", new Date());
        return (Client) query.getSingleResult();
    }


    /**
     * AQUI É UTILIZADA A CRITERIA QUERY, É UM MODO DE CRIAR QUERIES UTILIZANDO SOMENTE CÓDIGO, É A MELHOR FORMA DE CRIAR
     * QUERIES DINÂMICAS, COMO NUM FILTRO DE TABELA LAZY EM QUE ADICIONA-SE NA BUSCA SOMENTE OS CAMPOS QUE O USUÁRIO INFORMOU
     *
     * @return
     */
    public List<Client> findCriteria() {

        final CriteriaBuilder cb = this.em.getCriteriaBuilder();
        final CriteriaQuery<Client> cQuery = cb.createQuery(Client.class);
        final Root<Client> root = cQuery.from(Client.class);

        final List<Predicate> where = new ArrayList<>();

        where.add(
                cb.equal(
                        root.get("createdAt"), new Date()
                )
        );

        cQuery.where(where.toArray(Predicate[]::new));

        return this.em.createQuery(cQuery).getResultList();
    }

}