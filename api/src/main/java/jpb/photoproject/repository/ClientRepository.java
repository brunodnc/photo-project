package jpb.photoproject.repository;

import jpb.photoproject.classes.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * CONFIGURED ON EntityManagerConfiguration
 */
public interface ClientRepository extends JpaRepository<Client, Long> {


    List<Client> findByPhotographerId(Long photographerId);


    //REPOSITÓRIOS SÃO INTERFACES QUE SÃO INJETADAS COM ALGUMAS IMPLEMENTAÇÕES
    //EXTENDEM A INTERFACE JpaRepository QUE JÁ CONTÉM ALGUNS MÉTODOS GENÉRICOS COMO: findAll(), save(), etc...


    /**
     * É POSSÍVEL CRIAR QUERY UTILIZANDO SOMENTE O NOME DO MÉTODO, NO CASO O SPRING IRÁ TRANSFORMAR O MÉTODO
     * NUMA QUERY UTILIZANDO AS COLUNAS ID E NAME. NOTA-SE QUE A ORDEM DOS PARAMETROS IMPORTA
     *
     * @param id
     * @param name
     * @return
     */
    public List<Client> findByIdAndName(final long id, final String name);


    /**
     * AQUI É UTILIZADA A ANOTAÇÃO PARA CRIAR UMA JQL/HQL, NESSE CASO O NOME DO MÉTODO NÃO IMPORTA, MAS OS NOMES DOS PARÂMETROS
     * DO MÉTODO DEVEM SER COMPATÍVEIS COM OS PARÂMETROS DA QUERY
     *
     * @param id
     * @param name
     * @return
     */
    @Query("FROM Client WHERE id = :id AND name = :name")
    public List<Client> findCustomizado(final long id, final String name);


    /**
     * AQUI É UTILIZADA A ANOTAÇÃO COM QUERY NATIVA, NOVAMENTE O NOME DOS PARÂMETROS DO MÉTODO DEVEM SER IGUAIS AOS PARÂMETROS DA QUERY
     *
     * @param id
     * @param name
     * @return
     */
    @Query(nativeQuery = true, value = "SELECT * FROM Client WHERE id = :id AND name = :name")
    public List<Client> findCustomizadoNativo(final long id, final String name);
}