package hemomax.api.domain.assinatura;

public record DadosListagemAssinatura(Long id, String plano, String dataTransicao) {
    public DadosListagemAssinatura(Assinatura assinatura){
        this(assinatura.getId(),assinatura.getPlano(),assinatura.getDataTransacao());
    }
}
