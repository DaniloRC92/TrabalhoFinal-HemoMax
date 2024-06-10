package hemomax.api.controller;

import hemomax.api.domain.endereco.DadosAtualizacaoEndereco;
import hemomax.api.domain.endereco.DadosCadastroEndereco;
import hemomax.api.domain.endereco.DadosDetalhamentoEndereco;
import hemomax.api.domain.endereco.DadosListagemEndereco;
import hemomax.api.domain.endereco.Endereco;
import hemomax.api.domain.endereco.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro/2.2")
public class EnderecoController {
    @Autowired
    private EnderecoRepository repository;
    @PostMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoEndereco> cadastrar(@RequestBody @Valid DadosCadastroEndereco dados, UriComponentsBuilder uriBuilder){
        var endereco = new Endereco(dados);
        repository.save(endereco);
        var uri = uriBuilder.path("/cadastro/2.2/{id}")
                .buildAndExpand(endereco.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoEndereco(endereco));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemEndereco>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemEndereco::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoEndereco> detalhar(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }
    @PutMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoEndereco> atualizar(@RequestBody @Valid DadosAtualizacaoEndereco dados){
        var endereco = repository.getReferenceById(dados.id());
        endereco.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoEndereco(endereco));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        // repository.deleteById(id); Exclusão física
        var endereco = repository.getReferenceById(id);
        endereco.excluir(); // Exclusão lógica

        return ResponseEntity.noContent().build();
    }
}
