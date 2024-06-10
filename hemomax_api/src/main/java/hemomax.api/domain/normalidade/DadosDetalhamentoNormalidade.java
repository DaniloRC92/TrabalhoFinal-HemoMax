package hemomax.api.domain.normalidade;

public record DadosDetalhamentoNormalidade(
        Long id
) {
    public DadosDetalhamentoNormalidade(Normalidade normalidade){
        this(normalidade.getId());
    }
}
