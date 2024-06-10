package hemomax.api.domain.biomedico;

public record DadosListagemBiomedico(
        Long id,
        String nome,
        String cpf,
        String email
) {
    public DadosListagemBiomedico(Biomedico biomedico){
        this(biomedico.getId(),biomedico.getNome(), biomedico.getCpf(), biomedico.getEmail());
    }
}
