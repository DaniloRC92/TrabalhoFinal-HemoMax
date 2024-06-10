package hemomax.api.domain.responsavel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel,Long> {
    Responsavel findByEmail(String email);
    Page<Responsavel> findAll(Pageable paginacao);
}
