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
    public ResponseEntity<DadosDetalhamentoLaudo> cadastrar(UriComponentsBuilder uriBuilder){
        var laudo = new Laudo();
        repository.save(laudo);
        var uri = uriBuilder.path("/laudo/{id}")
                .buildAndExpand(laudo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoLaudo(laudo));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemLaudo>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemLaudo::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoLaudo> detalhar(@PathVariable Long id){
        var responsavel = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoLaudo(responsavel));
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        // repository.deleteById(id); Exclusão física
        var laudo = repository.getReferenceById(id);
        laudo.excluir(); // Exclusão lógica

        return ResponseEntity.noContent().build();
    }
}
