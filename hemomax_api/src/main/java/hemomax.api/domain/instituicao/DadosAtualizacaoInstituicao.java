package hemomax.api.domain.instituicao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstituicao(
        @NotNull
        Long id,
        @NotBlank
        String nome
) {
}
