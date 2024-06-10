package hemomax.api.controller;

import hemomax.api.domain.instituicao.DadosAtualizacaoInstituicao;
import hemomax.api.domain.instituicao.DadosCadastroInstituicao;
import hemomax.api.domain.instituicao.DadosDetalhamentoInstituicao;
import hemomax.api.domain.instituicao.DadosListagemInstituicao;
import hemomax.api.domain.instituicao.Instituicao;
import hemomax.api.domain.instituicao.InstituicaoRepository;
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
@RequestMapping("/cadastro/2.1")
public class InstituicaoController {
    @Autowired
    private InstituicaoRepository repository;
    @PostMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoInstituicao> cadastrar(@RequestBody @Valid DadosCadastroInstituicao dados, UriComponentsBuilder uriBuilder){
        var instituicao = new Instituicao(dados);
        repository.save(instituicao);
        var uri = uriBuilder.path("/cadastro/2.1/{id}")
                .buildAndExpand(instituicao.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoInstituicao(instituicao));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstituicao>> listar(@PageableDefault(size=10,sort={"nome"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosListagemInstituicao::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstituicao> detalhar(@PathVariable Long id){
        var instituicao = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoInstituicao(instituicao));
    }
    @PutMapping
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<DadosDetalhamentoInstituicao> atualizar(@RequestBody @Valid DadosAtualizacaoInstituicao dados){
        var instituicao = repository.getReferenceById(dados.id());
        instituicao.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoInstituicao(instituicao));
    }
    @DeleteMapping("/{id}")
    @Transactional
    @Secured("ADM_USER")
    public ResponseEntity<Object> excluir (@PathVariable Long id){
        var instituicao = repository.getReferenceById(id);

        return ResponseEntity.noContent().build();
    }
}
