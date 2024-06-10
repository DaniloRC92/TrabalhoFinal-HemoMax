package hemomax.api.domain.responsavel;

public record DadosDetalhamentoResponsavel(
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email
){
    public DadosDetalhamentoResponsavel(Responsavel responsavel){
        this(responsavel.getId(), responsavel.getNome(), responsavel.getCnpj(), responsavel.getTelefone(), responsavel.getEmail());
    }
}
