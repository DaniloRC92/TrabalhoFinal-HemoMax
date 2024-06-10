package hemomax.api.controller;

import hemomax.api.domain.assinatura.Assinatura;
import hemomax.api.domain.assinatura.AssinaturaRepository;
import hemomax.api.domain.assinatura.DadosCadastroAssinatura;
import hemomax.api.domain.assinatura.DadosDetalhamentoAssinatura;
import hemomax.api.domain.assinatura.DadosListagemAssinatura;
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
@RequestMapping("/assinatura")
public class AssinaturaController {
    @Autowired
    private AssinaturaRepository repository;
    @PostMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoAssinatura> cadastrar(@RequestBody @Valid DadosCadastroAssinatura dados, UriComponentsBuilder uriBuilder){
        var assinatura = new Assinatura(dados);
        repository.save(assinatura);
        var uri = uriBuilder.path("/assinatura/{id}")
                .buildAndExpand(assinatura.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoAssinatura(assinatura));
    }
    @GetMapping
    @Secured("ADM_USER")
    public ResponseEntity<Page<DadosListagemAssinatura>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemAssinatura::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoAssinatura> detalhar(@PathVariable Long id){
        var assinatura = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAssinatura(assinatura));
    }
}
