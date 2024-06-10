package hemomax.api.domain.instituicao;

import hemomax.api.domain.assinatura.Assinatura;
import hemomax.api.domain.biomedico.Biomedico;
import hemomax.api.domain.endereco.Endereco;
import hemomax.api.domain.normalidade.Normalidade;
import hemomax.api.domain.responsavel.Responsavel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "instituicoes")
@Entity(name = "instituicao")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instituicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String nome;
    @OneToMany(mappedBy = "instituicao")
    private List<Assinatura> assinatura;
    @OneToMany(mappedBy = "instituicao")
    private List<Biomedico> biomedico;
    @OneToOne
    @JoinColumn(name = "endereco")
    private Endereco endereco;
    @OneToOne
    @JoinColumn(name = "normalidade")
    private Normalidade normalidade;
    @OneToOne
    @JoinColumn(name = "responsavel")
    private Responsavel responsavel;
    public Instituicao(DadosCadastroInstituicao dados){
        this.nome = dados.nome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void atualizarInformacoes(DadosAtualizacaoInstituicao dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }

}
