package hemomax.api.domain.instituicao;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroInstituicao(
        @NotBlank
        String nome
) {
}
