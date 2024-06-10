package hemomax.api.controller;

import hemomax.api.domain.biomedico.Biomedico;
import hemomax.api.domain.biomedico.BiomedicoRepository;
import hemomax.api.domain.biomedico.DadosAtualizacaoBiomedico;
import hemomax.api.domain.biomedico.DadosCadastroBiomedico;
import hemomax.api.domain.biomedico.DadosDetalhamentoBiomedico;
import hemomax.api.domain.biomedico.DadosListagemBiomedico;
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
@RequestMapping("/cadastro/4")
public class BiomedicoController {
    @Autowired
    private BiomedicoRepository repository;
    @PostMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoBiomedico> cadastrar(@RequestBody @Valid DadosCadastroBiomedico dados, UriComponentsBuilder uriBuilder){
        var biomedico = new Biomedico(dados);
        repository.save(biomedico);
        var uri = uriBuilder.path("/cadastro/4/{id}")
                .buildAndExpand(biomedico.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoBiomedico(biomedico));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemBiomedico>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemBiomedico::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoBiomedico> detalhar(@PathVariable Long id){
        var biomedico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoBiomedico(biomedico));
    }
    @PutMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoBiomedico> atualizar(@RequestBody @Valid DadosAtualizacaoBiomedico dados){
        var biomedico = repository.getReferenceById(dados.id());
        biomedico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoBiomedico(biomedico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
