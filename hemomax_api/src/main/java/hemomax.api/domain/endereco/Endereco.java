package hemomax.api.domain.endereco;

import hemomax.api.domain.assinatura.Assinatura;
import hemomax.api.domain.instituicao.Instituicao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "enderecos")
@Entity(name = "endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String estado;
    private String cidade;
    private String bairro;
    private String rua;
    private int numero;
    private String complemento;
    private String cep;
    @OneToOne(mappedBy = "endereco")
    private Instituicao instituicao;
    public Endereco(DadosCadastroEndereco dados){
        this.estado = dados.estado();
        this.cidade = dados.cidade();
        this.bairro = dados.bairro();
        this.rua = dados.rua();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cep = dados.cep();
    }

    public Long getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public void atualizarInformacoes(DadosAtualizacaoEndereco dados) {
        if (dados.estado() != null) {
            this.estado = dados.estado();
        }
        if (dados.cidade() != null) {
            this.cidade = dados.cidade();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.rua() != null) {
            this.rua = dados.rua();
        }
        if (dados.numero() == 0) {
            this.numero = dados.numero();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
    }

}
