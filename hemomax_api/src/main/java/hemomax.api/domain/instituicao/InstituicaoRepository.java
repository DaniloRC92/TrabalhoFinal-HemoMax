package hemomax.api.domain.instituicao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstituicaoRepository extends JpaRepository<Instituicao,Long> {
    Page<Instituicao> findAll(Pageable paginacao);
}
