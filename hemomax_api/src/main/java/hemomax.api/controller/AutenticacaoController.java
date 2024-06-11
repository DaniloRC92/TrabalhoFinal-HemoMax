package hemomax.api.controller;
import hemomax.api.domain.user.DadosAutenticacao;
import hemomax.api.domain.user.DadosRegistro;
import hemomax.api.domain.user.User;
import hemomax.api.domain.user.UserRepository;
import hemomax.api.infra.security.DadosTokenJWT;
import hemomax.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository repository;
    @PostMapping("/login")
    public ResponseEntity<DadosTokenJWT> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
    @PostMapping("/register")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> efetuarRegistro(@RequestBody @Valid DadosRegistro dados) {
        if (repository.findByLogin(dados.login())!= null) return ResponseEntity.badRequest().build();
        String senhaEncriptada = new BCryptPasswordEncoder().encode(dados.senha());
        User novoUsuario = new User(dados.login(),senhaEncriptada,dados.role(), dados.doc(), dados.telefone());
        repository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}
