package galacticos_app_back.galacticos.repository;

import galacticos_app_back.galacticos.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findByEstado(Boolean estado);
    List<Estudiante> findBySedeIdSede(Integer idSede);
    List<Estudiante> findByNivelActual(Estudiante.NivelActual nivel);
}
