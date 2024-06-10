package hemomax.api.controller;

import hemomax.api.domain.normalidade.DadosDetalhamentoNormalidade;
import hemomax.api.domain.normalidade.DadosListagemNormalidade;
import hemomax.api.domain.normalidade.Normalidade;
import hemomax.api.domain.normalidade.NormalidadeRepository;
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
@RequestMapping("/normalidade")
public class NormalidadeController {
    @Autowired
    private NormalidadeRepository repository;
    @PostMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoNormalidade> cadastrar(UriComponentsBuilder uriBuilder){
        var normalidade = new Normalidade();
        repository.save(normalidade);
        var uri = uriBuilder.path("/normalidade/{id}")
                .buildAndExpand(normalidade.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoNormalidade(normalidade));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemNormalidade>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemNormalidade::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoNormalidade> detalhar(@PathVariable Long id){
        var normalidade = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoNormalidade(normalidade));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        // repository.deleteById(id); Exclusão física
        var normalidade = repository.getReferenceById(id);
        normalidade.excluir(); // Exclusão lógica

        return ResponseEntity.noContent().build();
    }
}
