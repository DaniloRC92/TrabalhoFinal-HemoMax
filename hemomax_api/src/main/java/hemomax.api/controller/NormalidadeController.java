package hemomax.api.controller;

import hemomax.api.domain.normalidade.DadosDetalhamentoNormalidade;
import hemomax.api.domain.normalidade.Normalidade;
import hemomax.api.domain.normalidade.NormalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/normalidade")
public class NormalidadeController {
    @Autowired
    private NormalidadeRepository repository;
    @PostMapping
    @Transactional
    @Secured("ROLE_ADMIN")
    public ResponseEntity<DadosDetalhamentoNormalidade> cadastrar(UriComponentsBuilder uriBuilder){
        var normalidade = new Normalidade();
        repository.save(normalidade);
        var uri = uriBuilder.path("/normalidade/{id}")
                .buildAndExpand(normalidade.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoNormalidade(normalidade));
    }
    @GetMapping("/{id}")
    @Secured("ROLE_USER")
    public ResponseEntity<DadosDetalhamentoNormalidade> detalhar(@PathVariable Long id){
        var normalidade = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoNormalidade(normalidade));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
