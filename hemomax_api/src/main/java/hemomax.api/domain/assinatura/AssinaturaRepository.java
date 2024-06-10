package hemomax.api.domain.assinatura;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssinaturaRepository extends JpaRepository<Assinatura,Long> {
    Page<Assinatura> findAll(Pageable paginacao);
}
