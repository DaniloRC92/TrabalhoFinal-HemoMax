package hemomax.api.domain.normalidade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NormalidadeRepository extends JpaRepository<Normalidade,Long> {
    Page<Normalidade> findAll(Pageable paginacao);
}
