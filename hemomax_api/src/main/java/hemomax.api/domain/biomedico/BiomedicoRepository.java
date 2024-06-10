package hemomax.api.domain.biomedico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface BiomedicoRepository extends JpaRepository<Biomedico,Long> {
    Biomedico findByEmail(String email);
    Page<Biomedico> findAll(Pageable paginacao);
}
