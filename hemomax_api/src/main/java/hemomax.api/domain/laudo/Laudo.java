package hemomax.api.domain.laudo;

import hemomax.api.domain.user.User;
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
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "laudo_usuario",
            joinColumns =
                    { @JoinColumn(name = "laudos") },
            inverseJoinColumns =
                    { @JoinColumn(name = "usuarios") })
    private List<User> usuarios;
    public Laudo(){
    }

    public Long getId() {
        return id;
    }
}
