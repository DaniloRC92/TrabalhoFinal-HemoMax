package hemomax.api.domain.laudo;

public record DadosListagemLaudo(
        Long id
) {
    public DadosListagemLaudo(Laudo laudo){
        this(laudo.getId());
    }
}
