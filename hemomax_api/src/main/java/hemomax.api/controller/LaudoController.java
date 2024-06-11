package hemomax.api.controller;

import hemomax.api.domain.laudo.DadosDetalhamentoLaudo;
import hemomax.api.domain.laudo.DadosListagemLaudo;
import hemomax.api.domain.laudo.Laudo;
import hemomax.api.domain.laudo.LaudoRepository;
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
@RequestMapping("/laudo")
public class LaudoController {
    @Autowired
    private LaudoRepository repository;
    @PostMapping
    @Transactional
    @Secured("ROLE_USER")
    public ResponseEntity<DadosDetalhamentoLaudo> cadastrar(UriComponentsBuilder uriBuilder){
        var laudo = new Laudo();
        repository.save(laudo);
        var uri = uriBuilder.path("/laudo/{id}")
                .buildAndExpand(laudo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoLaudo(laudo));
    }
    @GetMapping
    @Secured("ROLE_USER")
    public ResponseEntity<Page<DadosListagemLaudo>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemLaudo::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    @Secured("ROLE_USER")
    public ResponseEntity<DadosDetalhamentoLaudo> detalhar(@PathVariable Long id){
        var laudo = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLaudo(laudo));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
