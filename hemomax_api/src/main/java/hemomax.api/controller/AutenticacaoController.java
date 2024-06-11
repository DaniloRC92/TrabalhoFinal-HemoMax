package hemomax.api.controller;

import hemomax.api.domain.biomedico.Biomedico;
import hemomax.api.domain.biomedico.BiomedicoRepository;
import hemomax.api.domain.responsavel.Responsavel;
import hemomax.api.domain.responsavel.ResponsavelRepository;
import hemomax.api.domain.user.DadosAutenticacao;
import hemomax.api.infra.security.DadosTokenJWT;
import hemomax.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ResponsavelRepository responsavelRepository;
    @Autowired
    private BiomedicoRepository biomedicoRepository;
    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        String tokenJWT;
        if (responsavelRepository.findByEmail(dados.login()) == null) {
            tokenJWT = tokenService.gerarToken((Biomedico) authentication.getPrincipal());
        } else {
            tokenJWT = tokenService.gerarToken((Responsavel) authentication.getPrincipal());
        }
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
