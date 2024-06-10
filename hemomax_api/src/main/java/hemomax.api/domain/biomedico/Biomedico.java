package hemomax.api.domain.biomedico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hemomax.api.domain.instituicao.Instituicao;
import hemomax.api.domain.laudo.Laudo;
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

@Table(name = "biomedicos")
@Entity(name = "biomedico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Biomedico implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    @JsonIgnore
    private String senha;
    private boolean ativo;
    @ManyToOne
    private Instituicao instituicao;
    @ManyToMany(mappedBy = "biomedicos")
    private List<Laudo> laudos;
    public Biomedico(DadosCadastroBiomedico dados){
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.email = dados.email();
        this.senha = dados.senha();
        ativo = true;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public void atualizarInformacoes(DadosAtualizacaoBiomedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.senha() != null) {
            this.senha = dados.senha();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("BIOMEDICO_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
