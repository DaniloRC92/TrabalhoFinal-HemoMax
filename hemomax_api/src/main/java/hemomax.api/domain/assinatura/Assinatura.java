package hemomax.api.domain.assinatura;

import hemomax.api.domain.instituicao.Instituicao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "assinaturas")
@Entity(name = "assinatura")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Assinatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String dataTransacao;
    private String plano;
    @ManyToOne
    private Instituicao instituicao;
    public Assinatura(DadosCadastroAssinatura dados){
        this.plano = dados.plano();
        this.dataTransacao = dados.dataTransacao();
    }

    public Long getId() {
        return id;
    }

    public String getPlano() {
        return plano;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }
}
