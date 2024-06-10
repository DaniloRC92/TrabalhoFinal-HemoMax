package hemomax.api.domain.laudo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo,Long> {
    Page<Laudo> findAll(Pageable paginacao);
}
