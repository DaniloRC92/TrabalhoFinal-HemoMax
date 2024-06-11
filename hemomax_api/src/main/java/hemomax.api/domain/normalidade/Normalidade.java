package hemomax.api.domain.normalidade;

import hemomax.api.domain.user.User;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "normalidades")
@Entity(name = "normalidade")
@EqualsAndHashCode(of = "id")
public class Normalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(mappedBy = "normalidade")
    private User usuario;
    public Normalidade(){
    }

    public Long getId() {
        return id;
    }
}
