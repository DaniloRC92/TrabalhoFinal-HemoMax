package hemomax.api.controller;

import hemomax.api.domain.responsavel.DadosAtualizacaoResponsavel;
import hemomax.api.domain.responsavel.DadosCadastroResponsavel;
import hemomax.api.domain.responsavel.DadosDetalhamentoResponsavel;
import hemomax.api.domain.responsavel.DadosListagemResponsavel;
import hemomax.api.domain.responsavel.Responsavel;
import hemomax.api.domain.responsavel.ResponsavelRepository;
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
@RequestMapping("/cadastro/1")
public class ResponsavelController {
    @Autowired
    private ResponsavelRepository repository;
    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoResponsavel> cadastrar(@RequestBody @Valid DadosCadastroResponsavel dados, UriComponentsBuilder uriBuilder){
        var responsavel = new Responsavel(dados);
        repository.save(responsavel);
        var uri = uriBuilder.path("/cadastro/1/{id}")
                .buildAndExpand(responsavel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoResponsavel(responsavel));
    }

    @GetMapping
    @Secured("ADM_USER")
    public ResponseEntity<Page<DadosListagemResponsavel>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemResponsavel::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoResponsavel> detalhar(@PathVariable Long id){
        var responsavel = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoResponsavel(responsavel));
    }
    @PutMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoResponsavel> atualizar(@RequestBody @Valid DadosAtualizacaoResponsavel dados){
        var responsavel = repository.getReferenceById(dados.id());
        responsavel.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoResponsavel(responsavel));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
