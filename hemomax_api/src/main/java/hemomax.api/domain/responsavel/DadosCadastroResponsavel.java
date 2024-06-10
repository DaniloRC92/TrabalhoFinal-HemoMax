package hemomax.api.domain.responsavel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastroResponsavel(
        @NotBlank
        String nome,
        @NotBlank
        String cnpj,
        @NotBlank
        String telefone,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha
) {

}
