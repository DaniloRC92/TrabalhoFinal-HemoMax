package hemomax.api.domain.biomedico;

public record DadosDetalhamentoBiomedico(
        Long id,
        String nome,
        String cpf,
        String email
) {
    public DadosDetalhamentoBiomedico(Biomedico biomedico){
        this(biomedico.getId(),biomedico.getNome(), biomedico.getCpf(), biomedico.getEmail());
    }
}
