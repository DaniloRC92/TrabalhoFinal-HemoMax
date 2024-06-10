package hemomax.api.domain.assinatura;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroAssinatura(
        @NotBlank
        String plano,
        @NotBlank
        String dataTransacao
) {
}
