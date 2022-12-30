package jpb.photoproject.classes;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "client")
public class Client {

    @Id // indica que é a PK da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY)// indica que a PK é auto increment, se der erro tentar com GenerationType.SEQUENCE, pois o banco pode usar alguma função especifica para criação de ID incremental
    private Long id;

    @Column(name = "name")// mapeia a coluna com o atributo, existem outras opções para inserir na anotação
    private String name;

    @Transient// indica que esse atributo não existe no banco, caso contrário estoura erro
    private ArrayList<String> tabs; // TODO: change to tabs

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Photographer.class)//indica que é many to one e que é fetch LAZY, dessa forma o hibernate só irá buscar as relacoes quando solicitarmos
    @JoinColumn(name = "photographer", referencedColumnName = "id")// indica quais colunas fazem parte da relação
    private Photographer photographer; // TODO: change to photographer

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTabs() {
        return tabs;
    }

    public void setTabs(ArrayList<String> tabs) {
        this.tabs = tabs;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Photographer getPhotographer() {
        return photographer;
    }

    public void setPhotographer(Photographer photographer) {
        this.photographer = photographer;
    }
}
