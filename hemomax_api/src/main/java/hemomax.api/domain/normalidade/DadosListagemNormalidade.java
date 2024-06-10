package hemomax.api.domain.normalidade;

public record DadosListagemNormalidade(
        Long id
) {
    public DadosListagemNormalidade(Normalidade normalidade){
        this(normalidade.getId());
    }
}
