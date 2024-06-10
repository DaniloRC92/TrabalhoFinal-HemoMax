package hemomax.api.domain.responsavel;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoResponsavel(
        @NotNull
        Long id,
        String nome,
        String cnpj,
        String telefone,
        String email,
        String senha

) {

}
