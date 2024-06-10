package hemomax.api.domain.biomedico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroBiomedico(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha
) {
}
