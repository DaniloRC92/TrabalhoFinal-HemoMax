package hemomax.api.domain.laudo;

import hemomax.api.domain.biomedico.Biomedico;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

import java.util.List;

@Table(name = "laudos")
@Entity(name = "laudo")
@EqualsAndHashCode(of = "id")
public class Laudo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private boolean ativo;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "laudo_biomedico",
            joinColumns =
                    { @JoinColumn(name = "laudos") },
            inverseJoinColumns =
                    { @JoinColumn(name = "biomedicos") })
    private List<Biomedico> biomedicos;
    public Laudo(){
        ativo = true;
    }

    public Long getId() {
        return id;
    }

    public void excluir() {
        this.ativo = false;
    }
}