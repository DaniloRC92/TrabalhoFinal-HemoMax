package hemomax.api.domain.responsavel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hemomax.api.domain.instituicao.Instituicao;
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

@Table(name = "responsaveis")
@Entity(name = "responsavel")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Responsavel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nome;
    private String cnpj;
    private String telefone;
    private String email;
    @JsonIgnore
    private String senha;
    private boolean ativo;
    @OneToOne(mappedBy = "responsavel")
    private Instituicao instituicao;
    public Responsavel(DadosCadastroResponsavel dados) {
        nome = dados.nome();
        cnpj = dados.cnpj();
        telefone = dados.telefone();
        email = dados.email();
        senha = dados.senha();
        ativo = true;
    }
    public void atualizarInformacoes(DadosAtualizacaoResponsavel dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.cnpj() != null) {
            this.cnpj = dados.cnpj();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
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

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ADM_USER"));
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
