package cl.praxis.EscuelaRural_JPA.repository;

import cl.praxis.EscuelaRural_JPA.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

}
