package hemomax.api.domain.instituicao;

public record DadosListagemInstituicao(
        Long id,
        String nome
) {
    public DadosListagemInstituicao(Instituicao instituicao){
        this(instituicao.getId(), instituicao.getNome());
    }
}
