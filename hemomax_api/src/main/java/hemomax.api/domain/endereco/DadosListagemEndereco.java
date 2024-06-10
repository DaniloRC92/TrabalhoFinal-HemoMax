package hemomax.api.domain.endereco;

public record DadosListagemEndereco(
        Long id,
        String estado,
        String cidade,
        String bairro,
        String rua,
        int numero,
        String complemento,
        String cep
) {
    public DadosListagemEndereco(Endereco endereco){
        this(endereco.getId(), endereco.getEstado(), endereco.getCidade(), endereco.getBairro(), endereco.getRua(), endereco.getNumero(), endereco.getComplemento(), endereco.getCep());
    }
}
