package hemomax.api.domain.instituicao;

public record DadosDetalhamentoInstituicao(
        Long id,
        String nome
) {
    public DadosDetalhamentoInstituicao(Instituicao instituicao){
        this(instituicao.getId(), instituicao.getNome());
    }
}
