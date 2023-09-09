package fotografia.bruna.api.domain.membro;

import org.springframework.data.jpa.repository.JpaRepository;

// Interface Repository para o membro e herda de JpaRepository, sendo uma interface do Spring Data JPA
// Esse Repository substitui o DAO (Data Access Object)
public interface MembroRepository extends JpaRepository<Membro, Long> {

}
