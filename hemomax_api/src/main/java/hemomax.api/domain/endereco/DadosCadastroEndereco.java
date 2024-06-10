package hemomax.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroEndereco(
        @NotBlank
        String estado,
        @NotBlank
        String cidade,
        @NotBlank
        String bairro,
        @NotBlank
        String rua,
        @NotNull
        int numero,
        @NotBlank
        String complemento,
        @NotBlank
        String cep
) {
}
