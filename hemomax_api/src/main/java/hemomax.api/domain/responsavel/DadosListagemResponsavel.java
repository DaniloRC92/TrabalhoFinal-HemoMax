package hemomax.api.domain.responsavel;

public record DadosListagemResponsavel(
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email
) {
    public DadosListagemResponsavel(Responsavel responsavel) {
        this(responsavel.getId(), responsavel.getNome(), responsavel.getCnpj(), responsavel.getTelefone(), responsavel.getEmail());
    }
}
