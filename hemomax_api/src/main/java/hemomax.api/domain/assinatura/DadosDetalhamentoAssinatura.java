package hemomax.api.domain.assinatura;

public record DadosDetalhamentoAssinatura(Long id, String plano, String dataTransicao) {
    public DadosDetalhamentoAssinatura(Assinatura assinatura){
        this(assinatura.getId(),assinatura.getPlano(),assinatura.getDataTransacao());
    }
}
