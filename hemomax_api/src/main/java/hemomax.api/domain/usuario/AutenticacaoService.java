package hemomax.api.domain.usuario;

import hemomax.api.domain.biomedico.BiomedicoRepository;
import hemomax.api.domain.responsavel.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    private ResponsavelRepository responsavelRepository;
    @Autowired
    private BiomedicoRepository biomedicoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = responsavelRepository.findByEmail(username);
        if (user == null){
            user = biomedicoRepository.findByEmail(username);
        }
        return user;
    }
}
