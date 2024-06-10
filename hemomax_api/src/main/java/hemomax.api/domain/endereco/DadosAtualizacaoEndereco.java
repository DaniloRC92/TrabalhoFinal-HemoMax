package hemomax.api.domain.endereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoEndereco(
        @NotNull
        Long id,
        String estado,
        String cidade,
        String bairro,
        String rua,
        int numero,
        String complemento,
        String cep
) {
}
