package hemomax.api.domain.user;

import hemomax.api.domain.assinatura.Assinatura;
import hemomax.api.domain.endereco.Endereco;
import hemomax.api.domain.laudo.Laudo;
import hemomax.api.domain.normalidade.Normalidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "usuarios")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String login;
    private String senha;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String doc;
    private String telefone;
    @OneToMany(mappedBy = "usuario")
    private List<Assinatura> assinatura;
    @OneToOne
    @JoinColumn(name = "endereco")
    private Endereco endereco;
    @OneToOne
    @JoinColumn(name = "normalidade")
    private Normalidade normalidade;
    @ManyToMany(mappedBy = "usuarios")
    private List<Laudo> laudos;

    public User(String login, String senhaEncriptada, UserRole role, String doc, String telefone) {
        this.login = login;
        this.senha = senhaEncriptada;
        this.role = role;
        this.doc = doc;
        this.telefone = telefone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getDoc() {
        return doc;
    }

    public String getTelefone() {
        return telefone;
    }
}
