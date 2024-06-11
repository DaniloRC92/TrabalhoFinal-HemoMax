package hemomax.api.domain.user;

public record DadosRegistro(String login, String senha, UserRole role, String doc, String telefone) {
}
