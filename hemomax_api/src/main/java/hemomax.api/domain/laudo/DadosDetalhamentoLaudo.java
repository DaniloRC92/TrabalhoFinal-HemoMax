package hemomax.api.domain.laudo;

public record DadosDetalhamentoLaudo(
        Long id
) {
    public DadosDetalhamentoLaudo(Laudo laudo){
        this(laudo.getId());
    }
}
