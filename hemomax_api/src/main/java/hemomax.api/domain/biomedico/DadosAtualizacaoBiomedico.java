package hemomax.api.domain.biomedico;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoBiomedico(
        @NotNull
        Long id,
        String nome,
        String cpf,
        String email,
        String senha
) {
}
